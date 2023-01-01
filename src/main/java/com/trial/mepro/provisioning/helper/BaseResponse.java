package com.trial.mepro.provisioning.helper;


import java.util.HashMap;
import java.util.Map;

import com.trial.mepro.provisioning.Constants.GeneralConstants;

public class BaseResponse {
    Map<String, Object> res = new HashMap<>();

    public static Map<String, Object> success (Long status, Object data, String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("data", data);
        res.put("message", message);
        return res;
    }

    public static Map<String, Object> success (Long status, String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("data", GeneralConstants.EMPTY_STRING);
        res.put("message", message);
        return res;
    }

    public static Map<String, Object> success (String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", GeneralConstants.SUCCESS_CODE);
        res.put("data", GeneralConstants.EMPTY_STRING);
        res.put("message", message);
        return res;
    }
}
