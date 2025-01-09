
package com.lgitsolution.switcheshopcommon.supportticket.model;

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
@Table(name = "subscribe_details")
public class SupportTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ticket_id")
	private String ticketId;

	@Column(name = "customer_details_id")
	private int customerDetailsId;

	@Column(name = "order_item_id")
	private String orderItemId;

	@Column(name = "subject")
	private String subject;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "status")
	private int status;

	@Column(name = "response", columnDefinition = "text")
	private String response;

	@Column(name = "image", columnDefinition = "text")
	private String image;

	@Column(name = "created_at")
	private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;
}
