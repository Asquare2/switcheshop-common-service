
package com.lgitsolution.switcheshopcommon.paymentgateway.utility;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lgitsolution.switcheshopcommon.customer.dto.CustomerDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderDetailsDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderMetaDataDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderPaymentsResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentOrderRequestDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.dto.PaymentDetailConstants;
import com.lgitsolution.switcheshopcommon.paymentgateway.dto.PaymentDetailDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.model.PaymentDetail;
import com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.Utility.RazorpayUtility;
import com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto.RazorpayCurrenciesEnum;
import com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto.RazorpayOrderRequestDto;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static PaymentDetailDto convertModelToDto(PaymentDetail paymentDetail) {
    PaymentDetailDto paymentDetailDto = new PaymentDetailDto();
    paymentDetailDto.setId(paymentDetail.getId());
    paymentDetailDto.setOrderDetailId(paymentDetail.getOrderDetailId());
    paymentDetailDto.setAmount(paymentDetail.getAmount());
    paymentDetailDto.setProvider(paymentDetail.getProvider());
    paymentDetailDto.setSpStatus(paymentDetail.getSpStatus());
    paymentDetailDto.setCreatedAt(Utility.getLocalDateMillis(paymentDetail.getCreatedAt()));
    paymentDetailDto.setModifiedAt(Utility.getLocalDateMillis(paymentDetail.getModifiedAt()));
    paymentDetailDto.setSpOrderId(paymentDetail.getSpOrderId());
    paymentDetailDto.setPaymentSessionId(paymentDetail.getPaymentSessionId());
    paymentDetailDto.setCreatedOrderResponse(Utility.convertJsonToObject(paymentDetail
            .getCreatedOrderResponse(), new OrderResponseDto()));
    paymentDetailDto.setOrderPaymentsResponseArr(Utility.convertJsonToObject(paymentDetail
            .getOrderPaymentsResponse(), new OrderPaymentsResponseDto[0]));
    paymentDetailDto.setStatus(paymentDetail.getStatus());
    paymentDetailDto.setOrderItemId(paymentDetail.getOrderItemId());
    paymentDetailDto.setPaymentMethod(paymentDetail.getPaymentMethod());
    return paymentDetailDto;
  }

  public static PaymentDetail convertDtoToModel(PaymentDetailDto dto) {
    PaymentDetail paymentDetail = new PaymentDetail();
    paymentDetail.setId(dto.getId());
    paymentDetail.setOrderDetailId(dto.getOrderDetailId());
    paymentDetail.setAmount(dto.getAmount());
    paymentDetail.setProvider(dto.getProvider());
    paymentDetail.setSpStatus(dto.getSpStatus());
    paymentDetail.setCreatedAt(Utility.getLocalDate(dto.getCreatedAt()));
    paymentDetail.setModifiedAt(Utility.getLocalDate(dto.getModifiedAt()));
    paymentDetail.setSpOrderId(dto.getSpOrderId());
    paymentDetail.setPaymentSessionId(dto.getPaymentSessionId());
    paymentDetail.setCreatedOrderResponse(Utility.ConvertObjectToJsonString(dto
            .getCreatedOrderResponse()));
    paymentDetail.setOrderPaymentsResponse(Utility.ConvertObjectToJsonString(dto
            .getOrderPaymentsResponseArr()));
    paymentDetail.setStatus(dto.getStatus());
    paymentDetail.setOrderItemId(dto.getOrderItemId());
    paymentDetail.setPaymentMethod(dto.getPaymentMethod());
    return paymentDetail;
  }

  /**
   * 
   * @param paymentDetail
   * @return
   */
  public static List<PaymentDetailDto> convertModelToDto(List<PaymentDetail> paymentDetail) {
    return paymentDetail.stream().map(paymentDetailL -> convertModelToDto(paymentDetailL)).toList();
  }

  /**
   * 
   * @param customerDetailsDto
   * @param orderDetilsDto
   * @param paymentGatewayName
   * @return
   */
  public static Object createPaymentOrderRequestDto(CustomerDetailsDto customerDetailsDto,
          OrderDetailsDto orderDetilsDto, String paymentGatewayName) {
    Object paymentOrderRequestDtoObjectL = null;
    if (PaymentDetailConstants.PAYMENT_PROVIDER_CASHFREE.equals(paymentGatewayName)) {
      paymentOrderRequestDtoObjectL = createPaymentOrderRequestDtoCashfree(customerDetailsDto,
              orderDetilsDto);
    } else if (PaymentDetailConstants.PAYMENT_PROVIDER_RAZORPAY.equals(paymentGatewayName)) {
      paymentOrderRequestDtoObjectL = createPaymentOrderRequestDtoRazorpay(customerDetailsDto,
              orderDetilsDto);
    }
    return paymentOrderRequestDtoObjectL;
  }

  /**
   * 
   * @param customerDetailsDto
   * @param orderDetilsDto
   * @return
   */
  private static PaymentOrderRequestDto createPaymentOrderRequestDtoCashfree(
          CustomerDetailsDto customerDetailsDto, OrderDetailsDto orderDetilsDto) {
    PaymentOrderRequestDto orderRequestDto = new PaymentOrderRequestDto();
    orderRequestDto.setOrder_amount((double) orderDetilsDto.getTotalPaymentGatwayPayable());
    orderRequestDto.setOrderItemId(orderDetilsDto.getItemId());
    orderRequestDto.getCustomer_details().setCustomer_id(customerDetailsDto.getId() + "");
    orderRequestDto.getCustomer_details().setCustomer_email(customerDetailsDto.getEmail());
    orderRequestDto.getCustomer_details().setCustomer_phone(customerDetailsDto.getMobile());
    orderRequestDto.setOrder_expiry_time(Utility.addMinutesToCurrentTime(18, ZoneId.of(
            "Asia/Kolkata")));
    /* Order Meta data details. */
    OrderMetaDataDto orderMetaDataDto = new OrderMetaDataDto();
    orderMetaDataDto.setReturn_url(
            "https://localhost:8081/order-details/get-update-order-status?orderItemId="
                    + orderDetilsDto.getItemId());
    orderRequestDto.setOrder_meta(orderMetaDataDto);
    return orderRequestDto;
  }

  /**
   * 
   * @param customerDetailsDto
   * @param orderDetilsDto
   * @return
   */
  private static RazorpayOrderRequestDto createPaymentOrderRequestDtoRazorpay(
          CustomerDetailsDto customerDetailsDto, OrderDetailsDto orderDetilsDto) {
    RazorpayOrderRequestDto orderRequestDto = new RazorpayOrderRequestDto();
    orderRequestDto.setAmount(RazorpayUtility.toRazorpayAmount(orderDetilsDto
            .getTotalPaymentGatwayPayable()));
    orderRequestDto.setReceipt(orderDetilsDto.getItemId());
    orderRequestDto.setCurrency(RazorpayCurrenciesEnum.INR.toString());
    Map<String, String> customerDetailsNoteMapL = new HashMap<>();
    customerDetailsNoteMapL.put("customer_id", String.valueOf(customerDetailsDto.getId()));
    customerDetailsNoteMapL.put("customer_email", customerDetailsDto.getEmail());
    customerDetailsNoteMapL.put("customer_mobile", customerDetailsDto.getMobile());
    orderRequestDto.setNotes(customerDetailsNoteMapL);
    return orderRequestDto;
  }

}
