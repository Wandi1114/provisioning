package com.trial.mepro.provisioning.Constants;

import java.time.LocalDateTime;

public final class GeneralConstants {

    //RESPONSE CODE
    public static final Long SUCCESS_CODE = 200L;
    public static final Long VALIDATION_CODE = 300L;
    public static final Long BAD_REQUEST_CODE = 400L;
    public static final Long UNAUTHORIZED_CODE = 401L;
    public static final Long FORBIDDEN_CODE = 403L;
    public static final Long FAIL_CODE = 500L;

    //RESPONSE MESSAGE
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String UNAUTHORIZED = "UNAUTHORIZED";

    public static final Long NULL_REF_VALUE_LONG = -99L;
    public static final int NULL_VALUE_INT = -99;
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final LocalDateTime CURRENT_LOCAL_DATE_TIME = LocalDateTime.now();

    public static final String COMMA_DELIMITER = ",";
    public static final String SEMICOLON_DELIMITER = ";";
    public static final String APPLICATION_TIME_ZONE = "Asia/Jakarta";
}
