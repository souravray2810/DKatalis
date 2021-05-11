@FirefoxBrowser
Feature: To test add Pillow in Cart flow

  Scenario: Check click funtionality on Buynow button
    Given Firefox Browser is open
    And User is on Homepage in Firefox Browser
    When User clicks on BuyNow in Firefox Browser
    Then Shopping Cart section should be displayed in Firefox Browser
    When User clicks on Checkout in Firefox Browser
    Then Order Summary pop up should be disaplyed in Firefox Browser
    And User clicks on Continue in Firefox Browser
    And User clicks on Credit-Debit Card in Firefox Browser
    And User enters Card Nummber, Exp Date & CVV in Firefox Browser
    When Hits on Pay Now in Firefox Browser
    And Users enters the Password in Firefox Browser
    When Hits on OK in Firefox Browser
    Then Order is confirmed in Firefox Browser

  Scenario: Check click funtionality on Buynow button
    Given Firefox Browser is open again
    And User is on Homepage in Firefox Browser failcase
    When User clicks on BuyNow in Firefox Browser failcase
    Then Shopping Cart section should be displayed in Firefox Browser failcase
    When User clicks on Checkout in Firefox Browser failcase
    Then Order Summary pop up should be disaplyed in Firefox Browser failcase
    And User clicks on Continue in Firefox Browser failcase
    And User clicks on Credit-Debit Card in Firefox Browser failcase
    And User enters Card Nummber, Exp Date & CVV in Firefox Browser failcase
    When Hits on Pay Now in Firefox Browser failcase
    And Users enters the Password in Firefox Browser failcase
    When Hits on OK in Firefox Browser failcase
    Then Transaction failed in Firefox Browser
