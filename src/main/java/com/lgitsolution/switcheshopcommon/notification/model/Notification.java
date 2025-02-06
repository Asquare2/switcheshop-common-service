
package com.lgitsolution.switcheshopcommon.notification.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.notification.dto.Priority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = Notification.TABLE_NAME)
public class Notification {

  public static final String TABLE_NAME = "notification";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "message", columnDefinition = "text")
  private String message;

  @Column(name = "role")
  private String role;

  @Column(name = "table_id")
  private Long tableId;

  @Column(name = "module_name")
  private String moduleName;

  @Column(name = "priority")
  @Enumerated(EnumType.STRING)
  private Priority priority;

  @Column(name = "is_mail")
  private boolean isMail = false;

  @Column(name = "is_mark_as_read")
  private boolean isMarkAsRead = false;

  @Column(name = "created_at")
  private LocalDate createdAt;

}
