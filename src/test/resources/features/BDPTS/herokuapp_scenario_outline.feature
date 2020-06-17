@bpdts-scenario-outline
Feature: BPDTS Herokuapp - Datadriven tests

  Background:
    Given A clean session with bpdts test url

  # Example of Scenario outline for data driven testing and
  # asserting specific json path value and response headers
  Scenario Outline: BPDTS GET requests for Heroku test app
    When a GET request with no authentication on endpoint <endpoint>
    Then the response status code is <responseCode>
    And the response header Content-Type equals application/json
    And the response header Connection equals keep-alive
    And the json response contains path <jsonPath> with value <expectedJsonValue>

    Examples:
      | endpoint           | responseCode | jsonPath  | expectedJsonValue                 |
      | users              | 200          | [1].email | bhalgarth1@timesonline.co.uk      |
      | city/Kundung/users | 200          | [0].email | bhalgarth1@timesonline.co.uk      |
      | user/2             | 200          | email     | bhalgarth1@timesonline.co.uk      |
      | user/xx            | 404          | message   | Id xx doesn't exist. You have requested this URI [/user/xx] but did you mean /user/<string:id> or /users ?               |
      | user/xxx           | 200          | NOTE      | This test will fail               |
