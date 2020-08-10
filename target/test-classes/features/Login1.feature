@LLogin
Feature: Login
  @ValidCredentials
  Scenario: verify valid credential
    Given I launch elementalSelenium application
    When I sign in with username "tomsmith" and password "SuperSecretPassword!" in login page
    Then I should see login secure page
    When I get logged out
    Then I should see login page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 1
    Given I launch elementalSelenium application
    When I sign in with username "" and password "" in login page
    Then I should get error message "Your username is invalid!" in login page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 2
    Given I launch elementalSelenium application
    When I sign in with username "John" and password "John123" in login page
    Then I should get error message "Your username is invalid!" in login page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 3
    Given I launch elementalSelenium application
    When I sign in with username "Siva" and password "Siva456" in login page
    Then I should get error message "Your username is invalid!" in login page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 4
    Given I launch elementalSelenium application
    When I sign in with username "tomsmith" and password "errorPassword" in login page
    Then I should get error message "Your password is invalid!" in login page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 5
    Given I launch elementalSelenium application
    When I sign in with username "errorUserName" and password "SuperSecretPassword?" in login page
    Then I should get error message "Your username is invalid!" in login page






