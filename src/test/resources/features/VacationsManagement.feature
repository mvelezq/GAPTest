Feature: VacationsManagementFeature
  This features is about login in the vacations management page, create a new user and delete the user

  Background:
    Given The user navigate to the login page
    When The user enter the username and password
    And The user click login button

  Scenario: Validate the correct login

    Then The user should see the logo
    Then The user should see his user information
    Then The user should see the banner with the message Signed in successfully.

  Scenario Outline: Create user
    Given The user click create new employee link
    When The user fill de form with his <firstname>, <lastname>, <email>, <id>, <startedworking> and <leader>
    Then The user verifies the entered fields <firstname>, <lastname>, <email>, <id>, <startedworking> and <leader>
    And The user return to the home page
    And The user counts what is the row number of his user with his <leader>
    Examples:
      | firstname | lastname | email          | id         | startedworking | leader       |
      | James     | Smith    | prueba@gap.com | 1234567890 | 1/21/2015      | Miguel Velez |



  Scenario Outline: Delete user
    When The user click delete in the register with his <leader>
    Then The user with his <leader> does not exist in the employees information page
  Examples:
    | leader       |
    | Miguel Velez |


