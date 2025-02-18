package com.lgitsolution.switcheshopcommon.companydetails.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactUsDetails {

  private String title;

  private String content;
  
  private String instaSupport;

  private String whatsAppSupport;

  private String facebookSupport;

  private String linkedInSupport;

  private String googleSupport;

  private String pinteRestSupport;

  private String xSupport;

  private String youtubeSupport;

}
