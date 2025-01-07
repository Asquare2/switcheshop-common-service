
package com.lgitsolution.switcheshopcommon.supportticket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.subcribe.dto.SubscribeDetailsDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportTicketDto {

  private int id;
  private String ticketId;
  private int customerDetailsId;
  private String orderItemId;
  private String subject;
  private String description;
  private int status;
  private String response;
  private String image;
  private long createdAt;
}
