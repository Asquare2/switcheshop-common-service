
package com.lgitsolution.switcheshopcommon.companydetails.utility;

import com.lgitsolution.switcheshopcommon.common.dto.CommonConstants;
import com.lgitsolution.switcheshopcommon.companydetails.dto.CompanyDetailsDto;
import com.lgitsolution.switcheshopcommon.companydetails.dto.TermsAndCondition;
import com.lgitsolution.switcheshopcommon.companydetails.model.CompanyDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static CompanyDetails convertCompanyDetailsDtoToModel(
          CompanyDetailsDto companyDetailsDto) {
    CompanyDetails companyDetails = new CompanyDetails();
    companyDetails.setId(companyDetailsDto.getId());
    companyDetails.setKey(companyDetailsDto.getKey());
    if (companyDetailsDto.getKey().equals(CommonConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      companyDetails.setValue(CommonUtility.ConvertObjectToJsonString(companyDetailsDto
              .getTermsAndConditionValue()));
    }
    return companyDetails;
  }

  public static CompanyDetailsDto convertCompanyDetailsModelToDto(CompanyDetails companyDetails) {
    CompanyDetailsDto companyDetailsDto = new CompanyDetailsDto();
    companyDetailsDto.setId(companyDetails.getId());
    companyDetailsDto.setKey(companyDetails.getKey());
    if (companyDetails.getKey().equals(CommonConstants.CMN_COMPANY_TERMS_AND_CONDITIONS)) {
      companyDetailsDto.setTermsAndConditionValue(CommonUtility.convertJsonToObject(companyDetails
              .getValue(), new TermsAndCondition()));
    }
    return companyDetailsDto;

  }
}