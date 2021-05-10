#Author: souravray281@gmail.com

Feature: To test add Pillow in Cart flow

	@ChromeBrowser
  Scenario: Check click funtionality on Buynow button
    Given Chrome Browser is open
    And User is on Homepage in Chrome Browser
    When User clicks on BuyNow in Chrome Browser
    Then Shopping Cart section should be displayed in Chrome Browser
    When User clicks on Checkout in Chrome Browser
    Then Order Summary pop up should be disaplyed in Chrome Browser
    And User clicks on Continue in Chrome Browser
    And User clicks on Credit-Debit Card in Chrome Browser
    And User enters Card Nummber, Exp Date & CVV in Chrome Browser
    When Hits on Pay Now in Chrome Browser
    And Users enters the Password in Chrome Browser
    When Hits on OK in Chrome Browser
    Then Order is confirmed in Chrome Browser
