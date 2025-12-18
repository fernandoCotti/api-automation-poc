@animal
Feature: Animal image retrieval

  Scenario Outline: Retrieve a random image for an animal
    Given the animal API "<animal>" is available
    When I request a random animal image
    Then the response status code should be 200
    And the response contains a valid image url

    Examples:
      | animal |
      | dog    |
      | cat    |
