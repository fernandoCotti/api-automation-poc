Feature: User management API

  As a consumer of the ReqRes API
  I want to manage users
  So that I can validate POST and PUT operations

  Scenario: Create a new user
    Given the user management API is available
    When I create a user with name "fernando" and job "automation"
    Then the response status code should be 201
    And the response should contain a user id


  Scenario: Update an existing user
    Given the user management API is available
    When I update user with id "2" using name "cotti" and job "tester"
    Then the response status code should be 200

  Scenario: Delete an existing user
    Given the user management API is available
    When I delete the user with id 1
    Then the response status code should be 200
