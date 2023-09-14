
Feature: BestBuy Add to Cart Verification

  @home_page
  Scenario: Add iPhone to Cart
  	Given User navigates to BestBuy HomePage
  	When User Search for a phone
  	Then User should get the exact result
  	And  User click on Add to Cart button
  	And User verifies the message on Cart page