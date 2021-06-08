@navigate
Feature:Navigating Certain Pages
  Scenario: Navigate to certain page
    Given the user is on the login page
    Given the user enter sales manager info
    When  Navigate from Fleet to Vehicle
    Then  Title should be Vehicle

  Scenario: Navigate to certain page
    Given the user is on the login page
    Given the user enter sales manager info
    When  Navigate from Marketing to Campaigns
    Then  Title should be Campaigns

  Scenario: Navigate to certain page
    Given the user is on the login page
    Given the user enter sales manager info
    When  Navigate from Activities to Calender Events
    Then  Title should be Calenders