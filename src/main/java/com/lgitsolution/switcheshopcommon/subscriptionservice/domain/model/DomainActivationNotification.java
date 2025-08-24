
package com.lgitsolution.switcheshopcommon.subscriptionservice.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "domain_activation_notification", schema = "public")
public class DomainActivationNotification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "client_details_id")
  private int clientDetailId;

  @Column(name = "domain_name")
  private String domainName;

  @Column(name = "status")
  private int status;

  @Column(name = "created_at")
  private LocalDate createdAt;

}
