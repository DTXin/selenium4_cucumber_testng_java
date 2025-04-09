Feature: Login page automation of saucedemo application

  Scenario Outline: Login is successfully with valid username and password
    Given User is on Login Page
    When User enter valid username: <username> and password: <password>
    And Click on login button
    Then User is navigated to Product Page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |


  Scenario: Login is failed with invalid username and password
    Given User is on Login Page
    When User enter valid username: standard_user and password: secret_fail
    And Click on login button
    Then Verify error container is displayed
    Then Verify error message: Epic sadface: Username and password do not match any user in this service is existed