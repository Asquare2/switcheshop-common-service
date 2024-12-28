package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.labelandmanifest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelManifestResposeDto {

  private int status;
  private String manifest_url;
  private String label_url;
  private String label_created;
  private String message;
  private int status_code;

}
