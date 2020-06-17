@bpdts
Feature: BPDTS Heroku GET Requests

  Background:
    Given A clean session with bpdts test url

  Scenario: Test instructions text
    When a GET request with no authentication on endpoint /instructions
    Then the response status code is 200
    And the json response contains value Check that the data returned by the API is valid

  Scenario: Get All User List
    When a GET request with no authentication on endpoint /users
    Then the response status code is 200
    And the json response contains value bhalgarth1@timesonline.co.uk

  Scenario: Validate users in Kundung city
    When a GET request with no authentication on endpoint city/Kundung/users
    Then the response status code is 200
    And the json response contains value bhalgarth1@timesonline.co.uk

  Scenario: Validate user with id 2
    When a GET request with no authentication on endpoint user/2
    Then the response status code is 200
    And the json response contains value bhalgarth1@timesonline.co.uk

  Scenario: Validate error code 404 for invalid user id
    When a GET request with no authentication on endpoint user/xx
    Then the response status code is 404
    And the json response contains value Id xx doesn't exist.

  Scenario: This test will fail expecting 200 instead for 404 - negative test
    When a GET request with no authentication on endpoint user/does_not_exit
    Then the response status code is 200

  Scenario: Invalid city -  negative test
    When a GET request with no authentication on endpoint city/12345/users
    Then the response status code is 404