
package com.lgitsolution.switcheshopcommon.subscriptionservice.request.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subscription_pending_request", schema = "public")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionPendingRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "request_type")
  private String requestType;

  @Column(name = "is_run")
  private Short isRun;

  @Column(name = "table_id")
  private Integer tableId;

  @Column(name = "run_count")
  private Integer runCount;

  @Column(name = "max_run_count")
  private Integer maxRunCount;

  @Column(name = "request", columnDefinition = "TEXT")
  private String request;

  @Column(name = "responce", columnDefinition = "TEXT")
  private String response;

  @Column(name = "created_at")
  private LocalDate createdAt;
}
