@LLogin
Feature: Login
  Background:
    Given I launch elementalSelenium application
  @ValidCredentials
  Scenario: verify valid credential

    When I sign in with username "tomsmith" and password "SuperSecretPassword!" in login page
    Then I should see login secure page
    When I get logged out
    Then I should see login page
  @InvalidCredentials
  Scenario Outline: verify invalid credentials scenario 1
#    Given I launch elementalSelenium application
    When I sign in with username "<username>" and password "<password>" in login page
    Then I should get error message "<meassage>" in login page
    Examples:
      | username | password | meassage |
      | Admin    | admin124 |Your username is invalid!|
      | tomsmith | Admin123 |Your password is invalid!|
      | admin    | SuperSecretPassword! |Your username is invalid!|
#  @InvalidCredentials
#  Scenario: verify invalid credentials scenario 2
#    Given I launch elementalSelenium application
#    When I sign in with username "John" and password "John123" in login page
#    Then I should get error message "Your username is invalid!" in login page
#  @InvalidCredentials
#  Scenario: verify invalid credentials scenario 3
#    Given I launch elementalSelenium application
#    When I sign in with username "Siva" and password "Siva456" in login page
#    Then I should get error message "Your username is invalid!" in login page
#  @InvalidCredentials
#  Scenario: verify invalid credentials scenario 4
#    Given I launch elementalSelenium application
#    When I sign in with username "tomsmith" and password "errorPassword" in login page
#    Then I should get error message "Your password is invalid!" in login page
#  @InvalidCredentials
#  Scenario : verify invalid credentials scenario 5
##    Given I launch elementalSelenium application
#    When I sign in with username "errorUserName" and password "SuperSecretPassword?" in login page
#    Then I should get error message "Your username is invalid!" in login page








