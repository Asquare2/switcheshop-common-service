
package com.lgitsolution.switcheshopcommon.client.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.promocode.dto.CustomerPromoCodeDetails;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDetailsDto {

  private Integer id;

  private String username;

  private String compId;

  private String schema;

  private String url;

  private String mobileNumber;

  private String password;

  private String mappedUrl;

  private Map<Integer, CustomerPromoCodeDetails> promocodeDetails = null;

  private Long createdAt;
}
