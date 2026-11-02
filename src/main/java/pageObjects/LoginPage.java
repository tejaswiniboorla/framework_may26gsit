package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By signUpAndInBtn=By.xpath("//*[text()='Sign In / Sign Up']");	
	By signInBtn=By.xpath("//*[text()='Login']");
	By email=By.id("input-Email");
	By password=By.id("input-Password");
	By submitBtn=By.xpath("//*[@type='submit']");
	By loginText=By.xpath("(//div[@class='relative'])[3]");
	
	public WebElement getSignUpAndInBtn() {
		return driver.findElement(this.signUpAndInBtn);
	}
	

	public WebElement getSignInBtn() {
		return driver.findElement(this.signInBtn);
	}

	public WebElement getEmail() {
		return driver.findElement(this.email);
	}

	public WebElement getPassword() {
		return driver.findElement(this.password);
	}

	public WebElement getSubmitBtn() {
		return driver.findElement(this.submitBtn);
	}
	public WebElement getLoginText() {
		return driver.findElement(this.loginText);
	}




}
