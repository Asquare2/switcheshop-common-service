
package com.lgitsolution.switcheshopcommon.customer.utility;

import java.util.ArrayList;

import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerDetailsDto;
import com.lgitsolution.switcheshopcommon.customer.model.CustomerDetails;

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
    customerDetailsDto.setDob(Utility.getLocalDateTimeMillis(customerDetails.getDob()));
    customerDetailsDto.setGender(customerDetails.getGender());
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
    customerDetails.setDob(Utility.getLocalDateTime(customerDetailsDto.getDob()));
    customerDetails.setGender(customerDetailsDto.getGender());
    return customerDetails;
  }

}
