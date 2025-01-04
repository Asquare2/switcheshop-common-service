
package com.lgitsolution.switcheshopcommon.sku.model;

import com.lgitsolution.switcheshopcommon.product.model.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sku")
public class SKU {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "multi_media")
  private String multiMedia;

  // @Column(name = "product_id")
  // private Integer productId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "price")
  private Float price;

  @Column(name = "special_price")
  private Float specialPrice;

  @Column(name = "attribute_options")
  private String attributeOptions;

  @Column(name = "title")
  private String title;

  @Column(name = "short_desc", columnDefinition = "text")
  private String shortDescription;

  @Column(name = "long_desc", columnDefinition = "text")
  private String longDescription;

  @Column(name = "slug")
  private String slug;

  @Column(name = "dm_content", columnDefinition = "text")
  private String dmContent;

  @Column(name = "item_id")
  private String itemId;

  @Column(name = "sale_price")
  private Float salePrice;

  @Column(name = "discount_percentage")
  private Float discountPercentage;

  @Column(name = "flash_sale_id")
  private Integer flashSaleId;

  @Column(name = "search_values", columnDefinition = "text")
  private String searchValues;

}
