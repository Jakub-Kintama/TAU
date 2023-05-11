Feature: Web Login

  Scenario: User should be able to log in with valid credentials
    Given the user is on page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged in successfully
