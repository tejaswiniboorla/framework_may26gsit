package pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceFilterPage {
	
	WebDriver driver;
	By inStockCheckbox=By.xpath("//*[@type='checkbox']");
	By priceFilter=By.tagName("select");
	By itemCard=By.className("hover:shadow-lg");	
	public PriceFilterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getInStockCheckbox() {
		return this.driver.findElement(this.inStockCheckbox);
	}
	public WebElement getPriceFilter() {
		return this.driver.findElement(this.priceFilter);
	}
	public List<WebElement> getItemCard() {
		return this.driver.findElements(this.itemCard);
	}

}
