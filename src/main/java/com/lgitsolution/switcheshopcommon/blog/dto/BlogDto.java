package com.lgitsolution.switcheshopcommon.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogDto {
	private Integer id;

	private String title;

	private String slug;

	private Integer status;

	private Long createdAt;

	private String content;
	
	private String dmContent;

	/** This is multi media comes from User interface. */
	private Multimedia multiMedia;

}