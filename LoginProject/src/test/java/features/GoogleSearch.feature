Feature: Test Google Search functionality

  @Smoke
  Scenario: Verify google search for "iPhone"
    When User opens URL as 'http://www.google.com'
    And User search for "iPhone"
    And click on Enter button in the keyboard
#    Then  Page title should be "Dashboard / nopCommerce administration"

  @Smoke
  Scenario: Verify google search for "iPad"
    When User opens URL as 'http://www.google.com'
    And User search for "iPad"
    And click on Enter button in the keyboard
