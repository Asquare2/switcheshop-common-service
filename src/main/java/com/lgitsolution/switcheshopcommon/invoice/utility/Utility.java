
package com.lgitsolution.switcheshopcommon.invoice.utility;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.invoice.dto.InvoiceDetailsDto;
import com.lgitsolution.switcheshopcommon.invoice.dto.InvoiceItemDto;
import com.lgitsolution.switcheshopcommon.invoice.model.InvoiceDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static InvoiceDetails convertDtoToModel(InvoiceDetailsDto dto) {
    InvoiceDetails model = new InvoiceDetails();
    model.setId(dto.getId());
    model.setOrderDetailsId(dto.getOrderDetailsId());
    model.setCreatedAt(dto.getCreatedAt());
    model.setTotalPayable(dto.getTotalPayable());
    model.setTaxTotalAmount(dto.getTaxTotalAmount());
    model.setInvoiceNumber(dto.getInvoiceNumber());
    model.setInvoiceItemsDetailList(CommonUtility.ConvertObjectToJsonString(dto
            .getInvoiceItemsDetailList()));
    return model;
  }

  public static InvoiceDetailsDto convertModelToDto(InvoiceDetails model) {
    InvoiceDetailsDto dto = new InvoiceDetailsDto();
    dto.setId(model.getId());
    dto.setOrderDetailsId(model.getOrderDetailsId());
    dto.setCreatedAt(model.getCreatedAt());
    dto.setTotalPayable(model.getTotalPayable());
    dto.setTaxTotalAmount(model.getTaxTotalAmount());
    dto.setInvoiceNumber(model.getInvoiceNumber());
    dto.setInvoiceItemsDetailList(parseJsonToList(model.getInvoiceItemsDetailList()));
    return dto;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<InvoiceDetailsDto> convertModelToDto(List<InvoiceDetails> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

  /**
   * Parse json string to address details list.
   * 
   * @param json string
   * @return the list of address details
   */
  private static List<InvoiceItemDto> parseJsonToList(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, new TypeReference<ArrayList<InvoiceItemDto>>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse JSON to List<InvoiceItemDto>", e);
    }
  }
}
