package com.bpdts.herokuapp;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "csv-test-data/Generic_CSV_TestCases.csv")
public class CSV_TestSuite_Runner {

    private String Endpoint;
    private int StatusCode;
    private String ResponseMessage;
    private String JsonPath;

    private EnvironmentVariables vars;

    @Test
    public void CSVTestSuite() throws Exception {

        final String baseUri = vars.getProperty("bdpts.test.url");

        SerenityRest
                .given().baseUri(baseUri)
                .when().get(this.Endpoint)
                .then()
                    .header("Connection", "keep-alive")
                    .header("Content-Type", "application/json")
                    .statusCode(this.StatusCode)
                    .body(this.JsonPath, CoreMatchers.containsString(this.ResponseMessage));
    }
}

