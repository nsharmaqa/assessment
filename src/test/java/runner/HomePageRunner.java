package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions( tags = {"@home_page"},glue = {"stepdefs"}, plugin = {"html:target/cucumber-reports/HomePage/cucumber-pretty","json:target/json-cucumber-reports/homepage/cukejson.json",
		"testng:target/testng-cucumber-reports/HomePage/cuketestng.xml" }, features = {"src/test/resources/features/HomePage"})
public class HomePageRunner extends AbstractTestNGCucumberParallelTests {
	
	public static String iPhone;
	
	@Parameters({"iPhone"})
	@BeforeClass
	public static void before(String iPhone1) {
		iPhone = iPhone1;
		System.out.println("Before - "+System.currentTimeMillis());
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After - "+System.currentTimeMillis());
	}

}
