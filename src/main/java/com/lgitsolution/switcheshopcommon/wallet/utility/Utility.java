
package com.lgitsolution.switcheshopcommon.wallet.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.wallet.dto.CustomerWalletDto;
import com.lgitsolution.switcheshopcommon.wallet.dto.WalletTransactionDto;
import com.lgitsolution.switcheshopcommon.wallet.model.CustomerWallet;
import com.lgitsolution.switcheshopcommon.wallet.model.WalletTransaction;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static CustomerWallet convertDtoToModel(CustomerWalletDto dto) {
    CustomerWallet model = new CustomerWallet();
    model.setId(dto.getId());
    model.setCustomerDetailsId(dto.getCustomerDetailsId());
    model.setWalletId(dto.getWalletId());
    model.setModifiedAt(CommonUtility.getLocalDate(dto.getModifiedAt()));
    model.setBalance(Float.toString(dto.getBalance()));
    return model;
  }

  public static CustomerWalletDto convertModelToDto(CustomerWallet model) {
    CustomerWalletDto dto = new CustomerWalletDto();
    dto.setId(model.getId());
    dto.setCustomerDetailsId(model.getCustomerDetailsId());
    dto.setWalletId(model.getWalletId());
    dto.setModifiedAt(CommonUtility.getLocalDateMillis(model.getModifiedAt()));
    dto.setBalance(Float.parseFloat(model.getBalance()));
    return dto;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<CustomerWalletDto> convertModelToDto(List<CustomerWallet> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

  public static WalletTransaction convertDtoToModel(WalletTransactionDto dto) {
    WalletTransaction model = new WalletTransaction();
    model.setId(dto.getId());
    model.setCustomerDetailsId(dto.getCustomerDetailsId());
    model.setCustomerWalletId(dto.getCustomerWalletId());
    model.setTransactionId(dto.getTransactionId());
    model.setTransactionAmount(dto.getTransactionAmount());
    model.setTransactionType(dto.getTransactionType());
    model.setOrderDetailsId(dto.getOrderDetailsId());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    model.setReturnDetailsId(dto.getReturnDetailsId());
    model.setTransactionBy(dto.getTransactionBy());
    model.setTransactionFor(dto.getTransactionFor());
    model.setTransactionUserType(dto.getTransactionUserType());
    model.setOrderItemId(dto.getOrderItemId());
    model.setReturnItemId(dto.getReturnItemId());
    return model;
  }

  public static WalletTransactionDto convertModelToDto(WalletTransaction model) {
    WalletTransactionDto dto = new WalletTransactionDto();
    dto.setId(model.getId());
    dto.setCustomerDetailsId(model.getCustomerDetailsId());
    dto.setCustomerWalletId(model.getCustomerWalletId());
    dto.setTransactionId(model.getTransactionId());
    dto.setTransactionAmount(model.getTransactionAmount());
    dto.setTransactionType(model.getTransactionType());
    dto.setOrderDetailsId(model.getOrderDetailsId());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    dto.setReturnDetailsId(model.getReturnDetailsId());
    dto.setTransactionBy(model.getTransactionBy());
    dto.setTransactionFor(model.getTransactionFor());
    dto.setTransactionUserType(model.getTransactionUserType());
    dto.setOrderItemId(model.getOrderItemId());
    dto.setReturnItemId(model.getReturnItemId());
    return dto;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<WalletTransactionDto> convertWalletTransactionModelToDto(
          List<WalletTransaction> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

}
