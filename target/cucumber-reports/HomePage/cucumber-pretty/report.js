$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/HomePage/BestBuy_AddToCart.feature");
formatter.feature({
  "name": "BestBuy Add to Cart Verification",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add iPhone to Cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@home_page"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to BestBuy HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.aUserNavigatesToHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Search for a phone",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.aUserSearchesForPhone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get the exact result",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.aUserGetsExactSearchResult()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Add to Cart button",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.aUserClicksAddToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the message on Cart page",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.aUserVerifiedOnCart()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});