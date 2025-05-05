
package com.lgitsolution.switcheshopcommon.subscriptionservice.switcheshopdetails.utility;

import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyDetailsConstants;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyLogoDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ContactUsDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CustomerCareDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ReturnAndExchangePolicy;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TaxDetailsDto;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TermsAndCondition;
import com.lgitsolution.switcheshopcommon.subscriptionservice.switcheshopdetails.dto.SwitchEShopDetailsDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.switcheshopdetails.model.SwitchEShopDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static SwitchEShopDetails convertCompanyDetailsDtoToModel(SwitchEShopDetailsDto dto) {
    SwitchEShopDetails model = new SwitchEShopDetails();
    model.setId(dto.getId());
    model.setKey(dto.getKey());
    if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      model.setContent(dto.getTermsAndConditionValue().getContent());
      dto.getTermsAndConditionValue().setContent("");
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getTermsAndConditionValue()));
    } else if (dto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETUEN_AND_EXCHANGE_POLICY)) {
      model.setContent(dto.getReturnAndExchangePolicy().getContent());
      dto.getReturnAndExchangePolicy().setContent("");
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getReturnAndExchangePolicy()));
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DETAILS)) {
      model.setContent(dto.getContactUsDetails().getContent());
      dto.getContactUsDetails().setContent("");
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getContactUsDetails()));
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_CUSTOMER_CARE_DETAILS)) {
      model.setContent(dto.getCustomerCareDetails().getContent());
      dto.getCustomerCareDetails().setContent("");
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getCustomerCareDetails()));
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_LOGO_DETAILS)) {
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getCompanyLogoDetails()));
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TAX_DETAILS)) {
      model.setValue(CommonUtility.ConvertObjectToJsonString(dto.getTaxDetailsDto()));
    }
    return model;
  }

  public static SwitchEShopDetailsDto convertCompanyDetailsModelToDto(SwitchEShopDetails model) {
    SwitchEShopDetailsDto dto = new SwitchEShopDetailsDto();
    dto.setId(model.getId());
    dto.setKey(model.getKey());
    if (model.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      dto.setTermsAndConditionValue(CommonUtility.convertJsonToObject(model.getValue(),
              new TermsAndCondition()));
      dto.getTermsAndConditionValue().setContent(model.getContent());
    } else if (dto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETUEN_AND_EXCHANGE_POLICY)) {
      dto.setReturnAndExchangePolicy(CommonUtility.convertJsonToObject(model.getValue(),
              new ReturnAndExchangePolicy()));
      dto.getReturnAndExchangePolicy().setContent(model.getContent());
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DETAILS)) {
      dto.setContactUsDetails(CommonUtility.convertJsonToObject(model.getValue(),
              new ContactUsDetails()));
      dto.getContactUsDetails().setContent(model.getContent());
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_CUSTOMER_CARE_DETAILS)) {
      dto.setCustomerCareDetails(CommonUtility.convertJsonToObject(model.getValue(),
              new CustomerCareDetails()));
      dto.getCustomerCareDetails().setContent(model.getContent());
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_LOGO_DETAILS)) {
      dto.setCompanyLogoDetails(CommonUtility.convertJsonToObject(model.getValue(),
              new CompanyLogoDetails()));
    } else if (dto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TAX_DETAILS)) {
      dto.setTaxDetailsDto(CommonUtility.convertJsonToObject(model.getValue(),
              new TaxDetailsDto()));
    }
    return dto;
  }

}
