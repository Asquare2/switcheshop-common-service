package com.lgitsolution.switcheshopcommon.blog.model;

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
@Table(name = "blog")
public class Blog {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "multi_media")
	private String multiMedia;

	@Column(name = "slug")
	private String slug;
	
	@Column(name = "status")
    private Integer status;

	@Column(name = "content", columnDefinition="text")
	private String content;
	
	@Column(name = "dm_content", columnDefinition="text")
	private String dmContent;
	
	@Column(name = "created_at")
  private LocalDate createdAt;
}
