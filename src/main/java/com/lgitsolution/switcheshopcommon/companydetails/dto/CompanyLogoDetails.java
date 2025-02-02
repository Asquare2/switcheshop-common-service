package com.lgitsolution.switcheshopcommon.companydetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyLogoDetails {

  String companyName = "";
  String logoImage = "";
  String signatureImage = "";
  String faviconImage = "";
  String cdnThirtdPartyEndPoint = "";
  String cdnLocalEndPoint = "";
}
