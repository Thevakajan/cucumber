
@Login
Feature: Login

  @ValidCredentials
  Scenario: verify valid credential
    Given I launch OrangeHRM application
    When I sign in with username "Admin" and password "admin123"
    Then I should see dashbord page
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 2
    Given I launch OrangeHRM application
    When I sign in with username "Admin" and password "admin124"
    Then I should get error message "Invalid credentials"
  @InvalidCredentials
  Scenario: verify invalid credentials scenario 2
    Given I launch OrangeHRM application
    When I sign in with username "Admin" and password "Admin123"
    Then I should get error message "Invalid credentials"
