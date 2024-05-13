package com.example.demoPoi.constants;

public enum MessageErrors {
    EXCEL_INVALID,

    EXCEL_HEADER_INVALID,
    //UnAuthorized
    USER_UNAUTHORIZED,
    //ACCOUNT
    ACCOUNT_USERNAME_INVALID,

    ACCOUNT_OTP_INVALID,
    ACCOUNT_BIRTHDAY_INVALID,
    ACCOUNT_EMAIL_INVALID,
    ACCOUNT_PHONE_INVALID,
    ACCOUNT_ID_INVALID,
    ACCOUNT_ID_NOT_EXISTS,
    ACCOUNT_USERNAME_IS_EXISTS,
    ACCOUNT_USERNAME_IS_ACTIVE,
    ACCOUNT_USERNAME_NOT_EXISTS,
    ACCOUNT_LIST_FIELD_INVALID,
    ACCOUNT_MFA_ENABLED_INVALID,
    ACCOUNT_MFA_REGISTERED_INVALID,
    ACCOUNT_PASSWORD_INVALID,

    ACCOUNT_USERNAME_OR_PASS_INVALID,

    ACCOUNT_STATE_INVALID,

    ACCOUNT_CODE_INVALID,
    ACCOUNT_REFRESH_TOKEN_INVALID_OR_EXPIRED,
    ACCOUNT_IS_ACTIVE,
    ACCOUNT_ADMIN_CAN_NOT_EDIT,

    SERVER_ACCOUNT_UNAVAILABLE,

    SERVER_EMAIL_UNAVAILABLE,


    ACCOUNT_REDIRECT_INVALID,

    ACCOUNT_OAUTH2_INVALID,

    //CATEGORY
    CATEGORY_NAME_INVALID,
    CATEGORY_LIST_FIELD_INVALID,
    CATEGORY_IMAGE_INVALID,

    //PRODUCT
    PRODUCT_NAME_INVALID,
    PRODUCT_LIST_FIELD_INVALID,
    PRODUCT_IMAGE_INVALID,
    PRODUCT_QUANTITY_INVALID,
    PRODUCT_PRICE_INVALID,
    PRODUCT_DISCOUNT_INVALID,
    PRODUCT_ID_CATEGORY_INVALID,
    PRODUCT_CATEGORY_INVALID,
    PRODUCT_CATEGORY_NOT_EXISTS,

    PRODUCT_OUT_OF_STOCK,

    PRODUCT_DO_NOT_HAVE_ENOUGH_STOCK,

    //SUPPLIER
    SUPPLIER_ID_INVALID,
    SUPPLIER_ID_NOT_EXISTS,
    SUPPLIER_PHONE_INVALID,
    SUPPLIER_ADDRESS_INVALID,
    SUPPLIER_LIST_FIELD_INVALID,

    //ORDER
    ORDER_LIST_FIELD_INVALID,
    ORDER_PRODUCT_INVALID,
    ORDER_SHIPPED_DATE_INVALID,

    ORDER_PRODUCT_ID_INVALID,
    ORDER_PRODUCT_ID_NOT_FOUND,

    DATE_INVALID

}
