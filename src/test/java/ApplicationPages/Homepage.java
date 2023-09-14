package ApplicationPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;

import WebConnector.webconnector;
import static WebConnector.webconnector.driver;
import java.io.IOException;

public class Homepage {
	webconnector wc=new webconnector();

    public void goToHomePage(String phone) throws InvalidFormatException, IOException{
    	String URL=wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "URL");
        driver.get(URL);
        wc.waitForCondition("PageLoad","",60);
    }

    public void searchPhone(String phone) throws InvalidFormatException, IOException{
    	String item =wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "Item");
        driver.findElement(By.id("gh-search-input")).sendKeys(item);
        driver.findElement(By.xpath("//button[@title='submit search']")).click();
        wc.waitForCondition("PageLoad","",60);
    }
    
    public void getExactResult(String phone) throws InvalidFormatException, IOException{
    	String description=wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "description");
    	String expectedModelName=wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "model");
    	String expectedPrice=wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "price");
        int size = driver.findElements(By.xpath("//a[contains(text(),'"+description+"')]")).size();
        if(size==1) {
        	Assert.assertTrue(true, "Desired iPhone not found on page.");
        }
        
        String actualmodelName = driver.findElement(By.xpath("//a[contains(text(),'"+description+"')]/../../div/div[2]/div[1]/span[2]")).getText();
        String actualPrice = driver.findElement(By.xpath("//a[contains(text(),'"+description+"')]/../../../div[3]/div[1]/div/div/div/div/div/div/div/div/div//div/span[1]")).getText();
       Assert.assertEquals(expectedModelName, actualmodelName,"Expected model name is not matching with Actual model name");
       Assert.assertEquals(expectedPrice, actualPrice,"Expected price is not matching with Actual price");

       
    }
    
    public void clickAddToCart(String phone) throws InvalidFormatException, IOException, InterruptedException{
    	String description=wc.getSpecificColumnData("./src/test/testdata/data.xls",phone, "description");
        driver.findElement(By.xpath("//a[contains(text(),'"+description+"')]/../../../div[3]/div[3]/div/div/div/div/div/div/button")).click();
        Thread.sleep(10000);
        int size = driver.findElements(By.xpath("//span[text()='Added to cart']")).size();
        if(size ==1) {
        	Assert.assertTrue(true, "Added to cart text is not present");
        }
    }
    
    public void VerifyonCartPage() throws InvalidFormatException, IOException{
    	
        driver.findElement(By.xpath("//a[@href='/cart']")).click();
        int size = driver.findElements(By.xpath("//span[text()='Added to cart']")).size();
        if(size ==1) {
        	Assert.assertTrue(true, "Added to cart text is not present");
        }
        
        String orderSummary = driver.findElement(By.id("cart-order-summary")).getText();
        String checkout = driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).getText();
        
        Assert.assertEquals(orderSummary, "Order Summary","Order Summary Text is not present");
        Assert.assertEquals(checkout, "Checkout","Checkout button is not present");


    }
}