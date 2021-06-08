@wip
Feature: Account Types


  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates "Activities" "Calendar Events"
    Then Title should contain "Calendar Events - Activities"


  Scenario: Sales Manager user
    Given the user logged in as "sales manager"
    When the user navigates "Customers" "Accounts"
    Then Title should contain "Accounts - Customers"


  Scenario: store manager user
    Given the user logged in as "store manager"
    When the user navigates "Customers" "Contacts"
    Then Title should contain "Contacts - Customers"


  Scenario Outline: Login with different users and accounts <usertype>
    Given the user logged in as "<usertype>"
    When the user navigates "<tab>" "<module>"
    Then Title should contain "<title>"

    Examples:
      | usertype      | tab        | module          | title                        |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | sales manager | Customers  | Accounts        | Accounts - Customers         |
      | store manager | Customers  | Contacts        | Contacts - Customers         |


  Scenario Outline: Login as given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <userType>  |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login

    Examples:
      | userType        | firstName | lastName |
      | user1           | John      | Doe      |
      | salesmanager101 | Peyton    | Harber   |
      | storemanager85  | Marcella  | Huels    |