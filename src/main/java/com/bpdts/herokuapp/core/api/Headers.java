package com.bpdts.herokuapp.core.api;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    /*
    Default Header list
     */
    Map<String, ?> getHeaders() {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Connection", "keep-alive");

        return headers;
    }
}
