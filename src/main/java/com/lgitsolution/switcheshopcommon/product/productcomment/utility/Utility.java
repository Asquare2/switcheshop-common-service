
package com.lgitsolution.switcheshopcommon.product.productcomment.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.product.productcomment.dto.ProductCommentDto;
import com.lgitsolution.switcheshopcommon.product.productcomment.model.ProductComment;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static ProductComment convertDtoToModel(ProductCommentDto productCommentDto) {

    ProductComment productComment = new ProductComment();
    productComment.setId(productCommentDto.getId());
    productComment.setProductId(productCommentDto.getProductId());
    productComment.setCustomerDetailsId(productCommentDto.getCustomerId());
    productComment.setOrderId(productCommentDto.getOrderId());
    productComment.setRatingStar(productCommentDto.getRatingStar());
    productComment.setComment(productCommentDto.getComment());
    productComment.setIsPublished(productCommentDto.getIsPublished());
    productComment.setCreatedAt(Utility.getLocalDate(productCommentDto.getCreatedAt()));
    productComment.setOrderItemId(productCommentDto.getOrderItemId());
    productComment.setCustomerName(productCommentDto.getCustomerName());  return productComment;
  }

  public static ProductCommentDto convertModelToDto(ProductComment productComment) {
    ProductCommentDto productCommentDto = new ProductCommentDto();
    productCommentDto.setId(productComment.getId());
    productCommentDto.setProductId(productComment.getProductId());
    productCommentDto.setCustomerId(productComment.getCustomerDetailsId());
    productCommentDto.setOrderId(productComment.getOrderId());
    productCommentDto.setRatingStar(productComment.getRatingStar());
    productCommentDto.setComment(productComment.getComment());
    productCommentDto.setIsPublished(productComment.getIsPublished());
    productCommentDto.setCreatedAt(Utility.getLocalDateMillis(productComment.getCreatedAt()));
    productCommentDto.setOrderItemId(productComment.getOrderItemId());
    productCommentDto.setCustomerName(productComment.getCustomerName());
    return productCommentDto;
  }

  /**
   * 
   * @param productCommentList
   * @return
   */
  public static List<ProductCommentDto> convertModelToDto(List<ProductComment> productCommentList) {
    return productCommentList.stream().map(productComment -> convertModelToDto(productComment))
            .toList();
  }

}
