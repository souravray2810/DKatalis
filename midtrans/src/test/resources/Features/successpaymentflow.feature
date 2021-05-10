Feature: To test add Pillow in Cart flow

  Scenario: Check click funtionality on Buynow button
    Given Browser is open
    And User is on Homepage
    When User clicks on BuyNow
    Then Shopping Cart section should be displayed
    When User clicks on Checkout
    Then Order Summary pop up should be disaplyed
    And User clicks on Continue
    And User clicks on Credit-Debit Card
    And User enters Card Nummber, Exp Date & CVV
    When Hits on Pay Now
    And Users enters the Password
    When Hits on OK
    Then Order is confirmed
