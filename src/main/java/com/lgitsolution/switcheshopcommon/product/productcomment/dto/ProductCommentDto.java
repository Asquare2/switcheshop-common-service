
package com.lgitsolution.switcheshopcommon.product.productcomment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCommentDto {

  private Integer id;

  private Integer productId;

  private Integer customerId;

  private String customerName;

  private Integer orderId;

  private Integer ratingStar;

  private String comment;

  private Integer isPublished;

  private Long createdAt;

}
