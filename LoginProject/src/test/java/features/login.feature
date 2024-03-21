Feature: Test login functionality

  @Smoke
  Scenario: Verify user login with valid credentials
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When click on Logout button
    Then  Page title should be "Your store. Login"

  @DataTable
  Scenario: Verify user login with valid credentials - Data Table without Header
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters valid credentials
      | admin@yourstore.com | admin |
    And click on Login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When click on Logout button
    Then  Page title should be "Your store. Login"

  @DataTable
  Scenario: Verify user login with valid credentials - Data Table with Single Header
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters login credentials
      | Username            | Password |
      | admin@yourstore.com | admin    |
    And click on Login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When click on Logout button
    Then  Page title should be "Your store. Login"

  @Regression
  Scenario: Verify user login with invalid credentials - Data Table with Single Header
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters login credentials
      | Username             | Password |
      | admin1@yourstore.com | admin1   |
    And click on Login button
    Then Error message should contain the message 'Login was unsuccessful'

  @DataTable
  Scenario: Verify user login with credentials - Data Table with Header and Multiple Rows
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters invalid login credentials multiple times
      | Username             | Password |
      | admin1@yourstore.com | admin    |
      | admin1@yourstore.com | admin1   |

  @DataDriven
  Scenario Outline: Verify login with credentials - Scenario Outline
    When User opens URL as 'http://admin-demo.nopcommerce.com/login'
    And User enters email as "<Username>" and Password as "<password>"
    And click on Login button
    Then Page title should be "<Page title>"
    Examples:
      | Username             | password | Page title                             |
      | admin@yourstore.com  | admin    | Dashboard / nopCommerce administration |
      | admin1@yourstore.com | admin    | Your store. Login                      |
      | admin2@yourstore.com | admin    | Your store. Login                      |
      | admin3@yourstore.com | admin2   | Your store. Login                      |








