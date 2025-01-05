
package com.lgitsolution.switcheshopcommon.product.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.sku.model.SKU;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

  public Product() {

  }

  public Product(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "identification_no")
  private String productIdentificationNo;

  @Column(name = "title")
  private String title;

  @Column(name = "short_desc", columnDefinition = "text")
  private String shortDescription;

  @Column(name = "long_desc", columnDefinition = "text")
  private String longDescription;

  @Column(name = "made_in")
  private String madeIn;

  @Column(name = "type")
  private String type;

  @Column(name = "tag", columnDefinition = "text")
  private String tag;

  @Column(name = "tax_id")
  private int taxId;

  @Column(name = "tax_include")
  private int taxIncluded;

  @Column(name = "customer_type")
  private int customerType;

  @Column(name = "category_id")
  private int categoryId;

  @Column(name = "brand_id")
  private int brandId;

  @Column(name = "pickup_location")
  private int pickupLocation;

  @Column(name = "multi_media")
  private String multimedia;

  @Column(name = "minimum_order_quantity")
  private Integer minimumOrderQuantity;

  @Column(name = "maximum_order_quantity")
  private int maximumOrderQuantity;

  @Column(name = "quantity_step_size")
  private int quantityStepSize;

  @Column(name = "warranty_period")
  private int warrantyPeriod;

  @Column(name = "guarantee_period")
  private int guaranteePeriod;

  @Column(name = "delevery_type")
  private int deliveryType;

  @Column(name = "cod_allowed")
  private int codAllowed;

  @Column(name = "is_cancelable")
  private int cancelable;

  @Column(name = "is_returnable")
  private int returnable;

  @Column(name = "is_attachment_required")
  private int attachmentRequired;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private List<SKU> skuList = new ArrayList<SKU>();

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;

  @Column(name = "modified_by")
  private String modifiedBy;

  @Column(name = "status")
  private int status;

  @Column(name = "deliverable_zipcode")
  private String deliverableZipCode;

  @Column(name = "video_type")
  private int videoType = 0;

  @Column(name = "product_type")
  private int productType;

  @Column(name = "display_sku_on_attribute_id")
  private int displaySkuOnAttributeId;

  @Column(name = "is_display_sku_wise")
  private int isDisplaySkuWise;

  @Column(name = "specification_data", columnDefinition = "text")
  private String specificationData;

  /** For DM purpose */
  @Column(name = "slug")
  private String slug;

  @Column(name = "dm_content", columnDefinition = "text")
  private String dmContent;

  @Column(name = "item_id")
  private String itemId;

  @Column(name = "faq", columnDefinition = "text")
  private String faq;

  @Column(name = "rating_map")
  private String ratingMap;

}
