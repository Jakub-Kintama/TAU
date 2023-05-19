Feature: Web Login

  Scenario: User should be able to log in with valid credentials
    Given the user is on page
    When the user enters "standard_user" credentials
    And hits submit
    Then the user should be logged in successfully

  Scenario: User should not be able to log in with invalid credentials
    Given the user is on page
    When the user enters "invalid_user" credentials
    And hits submit
    Then the user should not be logged in successfully

  Scenario: User should not be able to log in with locked credentials
    Given the user is on page
    When the user enters "locked_out_user" credentials
    And hits submit
    Then the user should not be logged in successfully

  Scenario: User should be able to log in after 3 seconds with performance_glitch credentials
    Given the user is on page
    When the user enters "performance_glitch_user" credentials
    And hits submit
    Then the user should be logged in successfully after 3 seconds