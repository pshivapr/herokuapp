package com.bpdts.herokuapp.core.api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class RequestGet {

    private Headers headers = new Headers();
    private Response response;
    public static String baseUrl;

    /*
    Get Request without headers and authentication
     */
    public String getWithOutHeadersAndAuth(String endpoint) {
        response = SerenityRest
                .given().baseUri(baseUrl).accept("application/json")
                .when().get(endpoint)
                .thenReturn();

        return response.asString();
    }

    /*
    Get Request with headers and no authentication
     */
    public String getWithHeadersAndNoAuth(String endpoint) {
        response = SerenityRest
                .given().baseUri(baseUrl).headers(headers.getHeaders())
                .when().get(endpoint)
                .thenReturn();

        return response.asString();
    }

}