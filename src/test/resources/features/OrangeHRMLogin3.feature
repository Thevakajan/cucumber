
@Login
Feature: Login
 Background:
   Given I launch OrangeHRM application

  @ValidCredentials
  Scenario: : verify valid credential
    When I sign in with username "Admin" and password "admin123"
    Then I should see dashbord page

  @InvalidCredentials
  Scenario Outline: verify invalid credentials
    When I sign in with username "<username>" and password "<password>"
    Then I should get error message "Invalid credentials"
    Examples:
      | username | password |
      | Admin    | admin124 |
      | admin    | Admin123 |



