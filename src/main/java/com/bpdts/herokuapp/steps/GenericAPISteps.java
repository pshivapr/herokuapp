package com.bpdts.herokuapp.steps;

import com.bpdts.herokuapp.core.api.RequestGet;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class GenericAPISteps {

    @Steps
    private RequestGet request = new RequestGet();

    private EnvironmentVariables vars;
    private String jsonResponse;

    @Given("^A clean session with bpdts test url$")
    public void aCleanSessionWithBPDTSTestUrl() {
        SerenityRest.reset();
        RequestGet.baseUrl = vars.getProperty("bdpts.test.url");
    }

    @When("^a GET request with no authentication on endpoint (.*)$")
    public void aGetWithNoAuthentication(String endpoint)  {
        jsonResponse = request.getWithOutHeadersAndAuth(endpoint);
    }

    @Then("^the response status code is (.*)$")
    public void assertResponseStatusCode(int expectedStatusCode) {
        final int actualStatusCode = SerenityRest.then().extract().statusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("^the json response contains path (.*) with value (.*)$")
    public void assertJsonPathValue(String key, String expectedValue) {

        final String actualValue = SerenityRest.lastResponse().jsonPath().getObject(key, String.class);
        assertEquals(expectedValue, actualValue);
    }

    @And("^the json response contains value (.*)$")
    public void assertJsonPathValue(String expectedValue) {

        Assert.assertThat(jsonResponse, CoreMatchers.containsString(expectedValue));
    }

    @And("^the response header (.*) equals (.*)$")
    public void assertResponseHeader(String key, String expectedValue) {

        final String actualValue = SerenityRest.lastResponse().getHeader(key);
        assertEquals(expectedValue, actualValue);
    }

}
