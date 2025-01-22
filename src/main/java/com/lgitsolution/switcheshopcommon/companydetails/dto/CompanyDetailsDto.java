
package com.lgitsolution.switcheshopcommon.companydetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.dm.dto.DmCommonDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetailsDto {

  private Integer id;

  private String Key;

  private TermsAndCondition termsAndConditionValue;

  private ContactUsDetails contactUsDetails;

  private CustomerCareDetails customerCareDetails;

  private ReturnAndExchangePolicy returnAndExchangePolicy;

  private CompanyLogoDetails companyLogoDetails;

  private DmCommonDto homeDM;

  private TaxDetailsDto taxDetailsDto;

  private DmCommonDto faqDM;

}
