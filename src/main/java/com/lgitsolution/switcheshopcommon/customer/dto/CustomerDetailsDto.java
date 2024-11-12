
package com.lgitsolution.switcheshopcommon.customer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.authentication.dto.Provider;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailsDto {

  private Integer id;

  private String username;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  private String mobile;

  private List<CustomerAddressDetails> address;

  @Enumerated(EnumType.STRING)
  private Provider provider;

  private Long dob;
  
  @Enumerated(EnumType.STRING)
  private Gender gender;
  
}
