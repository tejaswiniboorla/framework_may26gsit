package stepDefinations;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.Base;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.PriceFilterPage;

public class B_validateFilterByPriceStep extends Base {
	// WebDriver driver;
	PriceFilterPage priceFilterPage;
	String inputRange;
	List<WebElement> flowerList;
	private static final Logger log = LogManager.getLogger(B_validateFilterByPriceStep.class);

	@Given("user is on search screen and in stock is checked")
	public void user_is_on_search_screen_and_in_stock_is_checked() {
		// driver=new ChromeDriver();
		try {
		//Thread.sleep(3000);
			getDriver().get(this.getData("frameworkUrl"));
			//Thread.sleep(3000);
			priceFilterPage = new PriceFilterPage(getDriver());
			priceFilterPage.getInStockCheckbox().click();
			// getDriver().findElement(By.xpath("//*[@type='checkbox']")).click();
			log.debug("CheckBox checked");

			//Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

	@When("Range {string} is selected")
	public void range_is_selected(String range) {
		try {

			WebElement filterByPrice = priceFilterPage.getPriceFilter();
			// getDriver().findElement(By.tagName("select"));
			inputRange = range;
			
			Select selectFilter = new Select(filterByPrice);
			selectFilter.selectByContainsVisibleText(inputRange);
			Thread.sleep(3000);
			flowerList = priceFilterPage.getItemCard();
			// getDriver().findElements(By.className("hover:shadow-lg"));
			System.out.println("size:" + flowerList.size());

		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

	@Then("price is validated")
	public void price_is_validated() {
		try {
			System.out.println(flowerList.size() + "*****SIZE");
			for (int i = 1; i <= flowerList.size(); i++) {
				String text = getDriver()
						.findElement(By.xpath("(//p[contains(@data-testid,'flower-price')])[" + i + "]")).getText();
				text = text.replaceAll("[^0-9]", "");
				System.out.println(text);

				if (inputRange.equals("Below ₹60") && !text.isEmpty()) {
					int value = Integer.parseInt(text);
					Assert.assertTrue(value < 60, "Value is not less than 60");
				} else if (inputRange.equals("₹60 - ₹70") && !text.isEmpty()) {
					int value = Integer.parseInt(text);

					Assert.assertTrue(value >= 60, "Value is not less than 60");
					Assert.assertTrue(value <= 70, "Value is not greater than 70");

				} else if (inputRange.equals("Above ₹70") && !text.isEmpty()) {
					int value = Integer.parseInt(text);
					Assert.assertTrue(value >= 70, "Value is not greater than 70");
				}

			}
			System.out.println("PRICE FILTER FOR " + inputRange + " is working");
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}

	}
}
