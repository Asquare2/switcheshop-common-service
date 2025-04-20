package com.lgitsolution.switcheshopcommon.client.model;

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
@Table(name = "client_details")
public class ClientDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "company_id")
  private String compId;

  @Column(name = "schema")
  private String schema;

  @Column(name = "url")
  private String url;

  @Column(name = "created_at")
  private LocalDate createdAt;

}
