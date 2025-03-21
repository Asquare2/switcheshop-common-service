
package com.lgitsolution.switcheshopcommon.invoice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDetailsDto {

  private Integer id;

  private Integer orderDetailsId;

  private String orderItemId;

  private LocalDate createdAt;

  private Float totalPayable;

  private String invoiceNumber;

  private List<InvoiceItemDto> invoiceItemsDetailList = new ArrayList<InvoiceItemDto>();

  private Float taxTotalAmount;

  @Enumerated(EnumType.STRING)
  private RefundStatus refundStatus = RefundStatus.no;

  private Float refundAmount = 0.0f;

}
