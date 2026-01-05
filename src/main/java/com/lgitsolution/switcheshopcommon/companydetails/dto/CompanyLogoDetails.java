package com.lgitsolution.switcheshopcommon.companydetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyLogoDetails {

  private String companyName = "";
  private String logoImage = "";
  private String signatureImage = "";
  private String faviconImage = "";
  private String domainName = "";
  private String cdnThirtdPartyEndPoint = "";
  private String cdnLocalEndPoint = "";
  private Multimedia multiMedia;

}
