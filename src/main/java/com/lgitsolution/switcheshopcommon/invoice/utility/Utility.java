
package com.lgitsolution.switcheshopcommon.invoice.utility;

import java.util.ArrayList;

import com.lgitsolution.switcheshopcommon.invoice.dto.InvoiceDetailsDto;
import com.lgitsolution.switcheshopcommon.invoice.dto.InvoiceItemDto;
import com.lgitsolution.switcheshopcommon.invoice.model.InvoiceDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static InvoiceDetails convertDtoToModel(InvoiceDetailsDto dto) {
    InvoiceDetails model = new InvoiceDetails();
    model.setId(dto.getId());
    model.setOrderDetailsId(dto.getOrderDetailsId());
    model.setOrderItemId(dto.getOrderItemId());
    model.setCreatedAt(dto.getCreatedAt());
    model.setPromocodeDiscount(dto.getPromocodeDiscount());
    model.setPromocodeName(dto.getPromocodeName());
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
    dto.setOrderItemId(model.getOrderItemId());
    dto.setCreatedAt(model.getCreatedAt());
    dto.setPromocodeDiscount(model.getPromocodeDiscount());
    dto.setPromocodeName(model.getPromocodeName());
    dto.setTotalPayable(model.getTotalPayable());
    dto.setTaxTotalAmount(model.getTaxTotalAmount());
    dto.setInvoiceNumber(model.getInvoiceNumber());
    dto.setInvoiceItemsDetailList(CommonUtility.convertJsonToObject(model
            .getInvoiceItemsDetailList(), new ArrayList<InvoiceItemDto>()));
    return dto;
  }
}
