package stepdefs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Parameters;

import ApplicationPages.Homepage;
import WebConnector.webconnector;
import cucumber.api.java.*;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.HomePageRunner;

public class HomePageSteps extends webconnector {
    private Homepage homePage;
	private String scenDesc;

    
	public HomePageSteps() {
        this.homePage = new Homepage();
    }
    
    @Before
	public void before(Scenario scenario) {
		this.scenDesc = scenario.getName();
		setUpDriver();
	}
    
    @After
    public void after(Scenario scenario){
    	closeDriver(scenario);
    }
	


	
    @Given("^User navigates to BestBuy HomePage$")
    public void aUserNavigatesToHomePage() throws InvalidFormatException, IOException {
        this.homePage.goToHomePage(HomePageRunner.iPhone);
    }
    
   @When("^User Search for a phone$")
    public void aUserSearchesForPhone() throws InvalidFormatException, IOException {
        this.homePage.searchPhone(HomePageRunner.iPhone);
    }

    @Then("^User should get the exact result$")
    public void aUserGetsExactSearchResult() throws InvalidFormatException, IOException {
        this.homePage.getExactResult(HomePageRunner.iPhone);
    }
 
    @And("^User click on Add to Cart button$")
    public void aUserClicksAddToCart() throws Exception {
        this.homePage.clickAddToCart(HomePageRunner.iPhone);
    }
    
    @And("^User verifies the message on Cart page$")
    public void aUserVerifiedOnCart() throws Exception {
        this.homePage.VerifyonCartPage();
    }
}
