Feature: Data table
  Scenario: User is perfoming sign in action
    Given User is on Home Page
    And   User click on Accounts and lists
    When  User entered phone number
      | 8580518606 |Pragati89@ |
    And  User entered password
      |Pragati89@ |
    Then  User has signed in and user is again on the home page

