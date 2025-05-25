
package com.lgitsolution.switcheshopcommon.subscriptionservice.switcheshopdetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyLogoDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ContactUsDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CustomerCareDetails;
import com.lgitsolution.switcheshopcommon.companydetails.dto.ReturnAndExchangePolicy;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TaxDetailsDto;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TermsAndCondition;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwitchEShopDetailsDto {

  private Integer id;

  private String Key;

  private TermsAndCondition termsAndConditionValue;

  private TermsAndCondition privacyPolicy;

  private ContactUsDetails contactUsDetails;

  private CustomerCareDetails customerCareDetails;

  private ReturnAndExchangePolicy returnAndExchangePolicy;

  private CompanyLogoDetails companyLogoDetails;

  private TaxDetailsDto taxDetailsDto;

}
