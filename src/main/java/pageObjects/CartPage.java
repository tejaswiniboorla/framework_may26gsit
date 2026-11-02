package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	WebDriver driver;
	By clearFilter=By.xpath("//*[text()='Clear Filters']");
	By inputSearch=By.xpath("//input[@data-testid='search-input']");
	By addToCardBtn=By.xpath("//*[text()='Add to Cart']");
	By cartBtn=By.xpath("//*[@data-testid='toggle-cart']");
	By itemName=By.xpath("//p[@class='font-semibold']");
	By itemQuantity = By.xpath("//button[text()='-']/following-sibling::span");
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}


	public WebElement getClearFilter() {
		return driver.findElement(this.clearFilter);
	}

	public WebElement getInputSearch() {
		return this.driver.findElement(this.inputSearch);
	}

	public WebElement getAddToCardBtn() {
		return this.driver.findElement(this.addToCardBtn);
	}

	public WebElement getCartBtn() {
		return this.driver.findElement(this.cartBtn);
	}

	public WebElement getItemName() {
		return this.driver.findElement(this.itemName);
	}

	public WebElement getItemQuantity() {
		return this.driver.findElement(this.itemQuantity);
	}
	


}
