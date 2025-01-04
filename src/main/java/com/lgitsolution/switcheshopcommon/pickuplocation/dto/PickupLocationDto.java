
package com.lgitsolution.switcheshopcommon.pickuplocation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupLocationDto {

  private Long id;

  private String pickupLocation;

  private String name;

  private String email;

  private String phone;

  private String city;

  private String state;

  private String country;

  private String pincode;

  private String address;

  private String address2;

  private Integer isVerified;

  private Integer isPrimary;

}
