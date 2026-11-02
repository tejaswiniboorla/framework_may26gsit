package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import base.Base;
import io.cucumber.java.en.*;
import pageObjects.CartPage;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C_validateAddToCartStep extends Base {
	// WebDriver driver;
	CartPage cartPage;

	private static final Logger log = LogManager.getLogger(C_validateAddToCartStep.class);
	String userFlower;
	String userQuantity;

	@Given("clear filter is applied")
	public void user_is_on_the_search_page_and_clear_filter_is_applied() {
		try {

			Thread.sleep(3000);
			// driver=new ChromeDriver();

			getDriver().get(this.getData("frameworkUrl"));

			//Thread.sleep(5000);
			getDriver().manage().window().maximize();
			System.out.println("REACHED CART");
			// System.out.println(driver.getCurrentUrl());
			//Thread.sleep(3000);

			cartPage = new CartPage(getDriver());
			cartPage.getClearFilter().click();

			// getDriver().findElement(By.xpath("//*[text()='Clear Filters']")).click();
			log.debug("Filter is cleared");
			// Thread.sleep(3000);
			System.out.println("CLEAR FILTER is clicked");
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

	@When("user search flower {string} and quantity {string}")
	public void user_search_flower_and_quantity(String flower, String quantity) {
		try {
			userFlower = flower;
			userQuantity = quantity;
			// System.out.println("REACHED METHOD2"+flower);

			this.cartPage.getInputSearch().sendKeys(flower);

			// getDriver().findElement(By.xpath("//input[@data-testid='search-input']"))

			//Thread.sleep(9000);
			for (int i = 1; i <= Integer.parseInt(quantity); i++) {
				this.cartPage.getAddToCardBtn().click();

				// getDriver().findElement(By.xpath("//*[text()='Add to Cart']")).click();

				log.debug("Add to Cart is clicked");
				//Thread.sleep(3000);
			}
			
			//Actions act=new Actions(getDriver());
			//act.moveToElement(this.cartPage.getCartBtn());
			
			JavascriptExecutor js=(JavascriptExecutor)getDriver();
			js.executeScript("window.scrollBy(o,-900);");
			
			//Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

	@Then("validate correct item is added")
	public void validate_correct_item_is_added() {
		try {
			// this.cartPage.getCartBtn().click();

			// getDriver.findElement(By.xpath("//*[@data-testid='toggle-cart']")).click();

			
			// Thread.sleep(3000);
			
			
			String flower = this.cartPage.getItemName().getText();

			// getDriver().findElement(By.xpath("//p[@class='font-semibold']"))
			System.out.println("FLOWER:" + flower);
			Assert.assertTrue(flower.equals(userFlower));
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

	@Then("validate correct item quantity")
	public void validate_correct_item_quantity() {

	    try {

	        String quantity = this.cartPage.getItemQuantity().getText();

	        quantity = quantity.trim();

	        System.out.println("Actual Quantity : " + quantity);
	        System.out.println("Expected Quantity : " + userQuantity);

	        Assert.assertEquals(quantity, userQuantity);

	    } catch (Exception ex) {
	    	log.error("Exception occurred:" + ex.getMessage());
	    }
	
	}
}
