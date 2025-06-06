
package com.lgitsolution.switcheshopcommon.customer.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerDetailsDto;
import com.lgitsolution.switcheshopcommon.customer.model.CustomerDetails;
import com.lgitsolution.switcheshopcommon.promocode.dto.CustomerPromoCodeDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  /**
   * Converts the model class object to dto class object.
   * 
   * @param customerDetails the model class object
   * @return the dto class object
   */
  public static CustomerDetailsDto convertModelToDto(CustomerDetails customerDetails) {
    CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
    customerDetailsDto.setId(customerDetails.getId());
    customerDetailsDto.setUsername(customerDetails.getUsername());
    customerDetailsDto.setPassword(customerDetails.getPassword());
    customerDetailsDto.setFirstName(customerDetails.getFirstName());
    customerDetailsDto.setLastName(customerDetails.getLastName());
    customerDetailsDto.setEmail(customerDetails.getEmail());
    customerDetailsDto.setMobile(customerDetails.getMobile());
    customerDetailsDto.setAddress(Utility.convertJsonToObject(customerDetails.getAddress(),
            new ArrayList<CustomerAddressDetails>()));
    customerDetailsDto.setProvider(customerDetails.getProvider());
    customerDetailsDto.setDob(Utility.getLocalDateMillis(customerDetails.getDob()));
    customerDetailsDto.setCreatedAt(Utility.getLocalDateMillis(customerDetails.getCreatedAt()));
    customerDetailsDto.setGender(customerDetails.getGender());
    customerDetailsDto.setRecentlyViewSkuId(Utility.convertJsonToObject(customerDetails
            .getRecentlyViewSkuId(), new LinkedList<Integer>()));
    if (customerDetails.getPromocode() != null && !customerDetails.getPromocode().isBlank()) {
      customerDetailsDto.setPromocodeDetails(parseJsonToMap(customerDetails.getPromocode()));
    }
    return customerDetailsDto;
  }

  /**
   * Converts the dto class object to model class object.
   * 
   * @param customerDetailsDto the dto class object
   * @return the model class object
   */
  public static CustomerDetails convertDtoToModel(CustomerDetailsDto customerDetailsDto) {
    CustomerDetails customerDetails = new CustomerDetails();
    customerDetails.setUsername(customerDetailsDto.getUsername());
    customerDetails.setPassword(customerDetailsDto.getPassword());
    customerDetails.setFirstName(customerDetailsDto.getFirstName());
    customerDetails.setLastName(customerDetailsDto.getLastName());
    customerDetails.setEmail(customerDetailsDto.getEmail());
    customerDetails.setMobile(customerDetailsDto.getMobile());
    customerDetails.setAddress(Utility.ConvertObjectToJsonString(customerDetailsDto.getAddress()));
    customerDetails.setProvider(customerDetailsDto.getProvider());
    customerDetails.setDob(Utility.getLocalDate(customerDetailsDto.getDob()));
    customerDetails.setCreatedAt(Utility.getLocalDate(customerDetailsDto.getCreatedAt()));
    customerDetails.setGender(customerDetailsDto.getGender());
    customerDetails.setRecentlyViewSkuId(Utility.ConvertObjectToJsonString(customerDetailsDto
            .getRecentlyViewSkuId()));
    customerDetails.setPromocode(Utility.ConvertObjectToJsonString(customerDetailsDto
            .getPromocodeDetails()));
    return customerDetails;
  }

  private static HashMap<Integer, CustomerPromoCodeDetails> parseJsonToMap(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json,
              new TypeReference<HashMap<Integer, CustomerPromoCodeDetails>>() {
              });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(
              "Failed to parse JSON to HashMap<String, CustomerPromoCodeDetails>", e);
    }
  }

  public static List<CustomerDetailsDto> convertModelToDto(List<CustomerDetails> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).collect(Collectors.toList());
  }

}
