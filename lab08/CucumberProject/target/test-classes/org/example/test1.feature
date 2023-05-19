Feature: Web Login

  @Valid
  Scenario: User should be able to log in with valid credentials
    Given the user is on page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged in successfully

  @Invalid
  Scenario: User should not be able to log in with invalid credentials
    Given the user is on page
    When the user enters invalid credentials
    And hits submit
    Then the user should not be logged in successfully

  @Valid
  Scenario: User should be able to log in with valid credentials
    Given the user is on page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged in successfully

  @Valid
  Scenario: User should be able to log in with valid credentials
    Given the user is on page
    When the user enters valid credentials
    And hits submit
    Then the user should be logged in successfully