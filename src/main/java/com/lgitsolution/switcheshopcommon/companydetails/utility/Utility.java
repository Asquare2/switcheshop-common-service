
package com.lgitsolution.switcheshopcommon.companydetails.utility;

import com.lgitsolution.switcheshopcommon.companydetails.dto.AppLinkDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyDetailsConstants;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyDetailsDto;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyLogoDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ContactUsDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CustomerCareDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ReturnAndExchangePolicy;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TaxDetailsDto;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TermsAndCondition;
import com.lgitsolution.switcheshopcommon.companydetails.model.CompanyDetails;
import com.lgitsolution.switcheshopcommon.dm.dto.DmCommonDto;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static CompanyDetails convertCompanyDetailsDtoToModel(
          CompanyDetailsDto companyDetailsDto) {
    CompanyDetails companyDetails = new CompanyDetails();
    companyDetails.setId(companyDetailsDto.getId());
    companyDetails.setKey(companyDetailsDto.getKey());
    if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      companyDetails.setContent(companyDetailsDto.getTermsAndConditionValue().getContent());
      companyDetailsDto.getTermsAndConditionValue().setContent("");
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getTermsAndConditionValue()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETUEN_AND_EXCHANGE_POLICY)) {
      companyDetails.setContent(companyDetailsDto.getReturnAndExchangePolicy().getContent());
      companyDetailsDto.getReturnAndExchangePolicy().setContent("");
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getReturnAndExchangePolicy()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DETAILS)) {
      companyDetails.setContent(companyDetailsDto.getContactUsDetails().getContent());
      companyDetailsDto.getContactUsDetails().setContent("");
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getContactUsDetails()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CUSTOMER_CARE_DETAILS)) {
      companyDetails.setContent(companyDetailsDto.getCustomerCareDetails().getContent());
      companyDetailsDto.getCustomerCareDetails().setContent("");
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getCustomerCareDetails()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_LOGO_DETAILS)) {
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getCompanyLogoDetails()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_HOME_DM_DETAILS)) {
      DmCommonDto dM = companyDetailsDto.getHomeDM();
      String slug = CommonUtility.getSlugByTitle(dM.getTitle());
      dM.setSlug(slug);
      companyDetailsDto.setHomeDM(dM);
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getHomeDM()));
    } else if (companyDetailsDto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TAX_DETAILS)) {
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getTaxDetailsDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_FAQ_DM_DETAILS)) {
      DmCommonDto dM = companyDetailsDto.getFaqDM();
      String slug = CommonUtility.getSlugByTitle(dM.getTitle());
      dM.setSlug(slug);
      companyDetailsDto.setFaqDM(dM);
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getFaqDM()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_TERM_CONDITION_DM_DETAILS)) {
      DmCommonDto dM = companyDetailsDto.getTermsAndConditionDM();
      String slug = CommonUtility.getSlugByTitle(dM.getTitle());
      dM.setSlug(slug);
      companyDetailsDto.setTermsAndConditionDM(dM);
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getTermsAndConditionDM()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETURN_ECXHANGE_DM_DETAILS)) {
      DmCommonDto dM = companyDetailsDto.getReturnAndExchangePolicyDM();
      String slug = CommonUtility.getSlugByTitle(dM.getTitle());
      dM.setSlug(slug);
      companyDetailsDto.setReturnAndExchangePolicyDM(dM);
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getReturnAndExchangePolicyDM()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DM_DETAILS)) {
      DmCommonDto dM = companyDetailsDto.getContactUsDM();
      String slug = CommonUtility.getSlugByTitle(dM.getTitle());
      dM.setSlug(slug);
      companyDetailsDto.setContactUsDM(dM);
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getContactUsDM()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_APP_LINK_DETAILS)) {
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getAppLinkDetails()));
    }
    return companyDetails;
  }

  public static CompanyDetailsDto convertCompanyDetailsModelToDto(CompanyDetails companyDetails) {
    CompanyDetailsDto companyDetailsDto = new CompanyDetailsDto();
    companyDetailsDto.setId(companyDetails.getId());
    companyDetailsDto.setKey(companyDetails.getKey());
    if (companyDetails.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      companyDetailsDto.setTermsAndConditionValue(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new TermsAndCondition()));
      companyDetailsDto.getTermsAndConditionValue().setContent(companyDetails.getContent());
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETUEN_AND_EXCHANGE_POLICY)) {
      companyDetailsDto.setReturnAndExchangePolicy(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new ReturnAndExchangePolicy()));
      companyDetailsDto.getReturnAndExchangePolicy().setContent(companyDetails.getContent());
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DETAILS)) {
      companyDetailsDto.setContactUsDetails(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new ContactUsDetails()));
      companyDetailsDto.getContactUsDetails().setContent(companyDetails.getContent());
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CUSTOMER_CARE_DETAILS)) {
      companyDetailsDto.setCustomerCareDetails(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new CustomerCareDetails()));
      companyDetailsDto.getCustomerCareDetails().setContent(companyDetails.getContent());
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_LOGO_DETAILS)) {
      companyDetailsDto.setCompanyLogoDetails(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new CompanyLogoDetails()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_HOME_DM_DETAILS)) {
      companyDetailsDto.setHomeDM(CommonUtility.convertJsonToObject(companyDetails.getValue(),
              new DmCommonDto()));
    } else if (companyDetailsDto.getKey().equals(CompanyDetailsConstants.CMN_COMPANY_TAX_DETAILS)) {
      companyDetailsDto.setTaxDetailsDto(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new TaxDetailsDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_FAQ_DM_DETAILS)) {
      companyDetailsDto.setFaqDM(CommonUtility.convertJsonToObject(companyDetails.getValue(),
              new DmCommonDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_TERM_CONDITION_DM_DETAILS)) {
      companyDetailsDto.setTermsAndConditionDM(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new DmCommonDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_RETURN_ECXHANGE_DM_DETAILS)) {
      companyDetailsDto.setReturnAndExchangePolicyDM(CommonUtility.convertJsonToObject(
              companyDetails.getValue(), new DmCommonDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_CONTACT_US_DM_DETAILS)) {
      companyDetailsDto.setContactUsDM(CommonUtility.convertJsonToObject(companyDetails.getValue(),
              new DmCommonDto()));
    } else if (companyDetailsDto.getKey().equals(
            CompanyDetailsConstants.CMN_COMPANY_APP_LINK_DETAILS)) {
      companyDetailsDto.setAppLinkDetails(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new AppLinkDetails()));
    }
    return companyDetailsDto;

  }
}