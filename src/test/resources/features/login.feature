
Feature: Users should be able to login

  @driver @VYT-123
  Scenario: Login as a driver
    Given the user is on the login page
    When the user enter the driver information
    Then the user should be able to login
  @smoke @VYT-123
  Scenario: Login as a sales manager
    Given the user is on the login page
    When the user enter sales manager info
    Then the user should be able to login
  @VYT-123
  Scenario: Login as a store manager
    Given the user is on the login page
    When the user enter store manager info
    Then the user should be able to login
    #comment