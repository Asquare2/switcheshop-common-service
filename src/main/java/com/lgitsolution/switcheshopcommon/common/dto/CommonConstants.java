
package com.lgitsolution.switcheshopcommon.common.dto;

public class CommonConstants {

  // Modules Names Constant Start
  /** The Constant CATEGORY_MODULE_NAME. */

  public static final String CATEGORY_MODULE_NAME = "Category";

  /** The Constant SKU_MODULE_NAME. */
  public static final String SKU_MODULE_NAME = "SKU";

  /** The Constant PRODUCT_MODULE_NAME. */
  public static final String PRODUCT_MODULE_NAME = "Product";

  /** The Constant SYSTEM_USER_MODULE_NAME. */
  public static final String SYSTEM_USER_MODULE_NAME = "System_User";

  /** The Constant ATTRIBUTE_MODULE_NAME. */
  public static final String ATTRIBUTE_MODULE_NAME = "ATTRIBUTE";

  /** The Constant FLASHSALE_MODULE_NAME. */
  public static final String FLASHSALE_MODULE_NAME = "FlashSale";

  /** The Constant PROMOCODE_MODULE_NAME. */
  public static final String PROMOCODE_MODULE_NAME = "Promocode";

  /** The Constant SLIDER_MODULE_NAME. */
  public static final String SLIDER_MODULE_NAME = "Slider";

  /** The Constant TAX_MODULE_NAME. */
  public static final String TAX_MODULE_NAME = "Tax";

  /** The Constant SALE_MODULE_NAME. */
  public static final String SALE_MODULE_NAME = "Sale";

  /** The Constant ORDER_MODULE_NAME. */
  public static final String ORDER_MODULE_NAME = "MANAGE_ORDER";

  /** The Constant ORDER_MODULE_NAME. */
  public static final String ORDER_RETURN_MODULE_NAME = "MANAGE_ORDER";

  // Modules Names Constant End

  // Credentials constants
  public static final String CMN_SERVICE_NAME_SHIP_ROCKET = "shipRocket";

  public static final String CMN_SERVICE_NAME_GOOGLE_AUTH = "googleAuth";

  public static final String CMN_SERVICE_NAME_TWILLO_MOBILE_OTP = "twillioMobileOtp";

  public static final String CMN_SERVICE_NAME_CASHFREE_P_GATEWAY = "cashFreePGateway";

  public static final String CMN_CONST_NAME_AUTH_TOKEN_KEY = "authToken";

  public static final String CMN_CONST_NAME_SUFY_THIRED_PARTY_STORAGE_KEY = "sufyStorage";

  public static final String CMN_SERVICE_NAME_FAST2SMS = "fast2sms";

  // Credentials constants End

  public static final String FILTER_CATEGORY_KEY = "category";

  public static final String FILTER_SPECIFICATION_KEY = "specification";

  public static final String FILTER_ATTRIBUTE_KEY = "attribute";

  public static final String FILTER_COLLECTION_KEY = "Collections";

  public static final String FILTER_STATUS_KEY = "status";

  /* Integer Constants */
  /** The active status value. */
  public static final int ACTIVE_STATUS = 1;

  public static final int INACTIVE_STATUS = 0;

  // Order module constant Start

  public static final String ORDER_PAYMENT_METHOD_PREPAID = "Prepaid";

  public static final String ORDER_PAYMENT_METHOD_COD = "COD";

  public static final String ORDER_PACKAGE_DIMENTION_LENGTH = "length";

  public static final String ORDER_PACKAGE_DIMENTION_BREADTH = "breadth";

  public static final String ORDER_PACKAGE_DIMENTION_HEIGHT = "height";

  public static final String ORDER_PACKAGE_DIMENTION_WEIGHT = "weight";

  // Order module constant End

  public static final String countKeyName = "count";

  public static final String listKeyName = "list";

  // Miscellaneous settings constant start

  /** The Constant key for sky prefix. */
  public static final String MIS_SETTING_SKU_PREFIX_KEY = "sku_prefix";

  /** The Constant key for product prefix. */
  public static final String MIS_SETTING_PRODUCT_PREFIX_KEY = "product_prefix";

  /** The Constant key for order prefix. */
  public static final String MIS_SETTING_ORDER_PREFIX_KEY = "order_detail_prefix";

  /** The Constant key for sky prefix. */
  public static final String MIS_SETTING_INVOICE_PREFIX_KEY = "invoice_prefix";

  public static final String MIS_SETTING_RETURN_ORDER_PREFIX_KEY = "return_order_detail_prefix";

  public static final String MIS_SETTING_REFUND_DETAIL_PREFIX_KEY = "refund_detail_prefix";

  // Miscellaneous settings constant end

  // search operations name start

  public static final String FILTER_OPERATION_EQUALS_KEY = "eq";

  // search operations name end

  /* Encryption key constant. */
  public static final String CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY =
          "sdfvgddsdsrsffffhgfduiquwdjhakshuhdiqwdhjknjked";
  
  public static final String TEST_ENVIORMENT_NAME = "test";

  public static final String PROD_ENVIORMENT_NAME = "prod";
}
