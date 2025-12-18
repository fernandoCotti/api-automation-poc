@nameprediction @get
Feature: Name prediction APIs

  As a consumer of public prediction APIs
  I want to retrieve information based on a given name
  So that I can validate different prediction services consistently

  Scenario Outline: Predict information based on name
    Given the "<apiType>" prediction API is available
    When I request a prediction for name "<name>"
    Then the response status code must be 200
    And the response should contain the name "<name>"
    And the response should contain prediction data

    Examples:
      | apiType     | name   |
      | gender      | lucas  |
      | nationality | matias  |
