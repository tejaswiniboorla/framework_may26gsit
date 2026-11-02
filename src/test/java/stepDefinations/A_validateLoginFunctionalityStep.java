package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import base.Base;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A_validateLoginFunctionalityStep extends Base {
	// WebDriver driver;
	LoginPage loginPage;
	private static final Logger log = LogManager.getLogger(A_validateLoginFunctionalityStep.class);

	@Given("user is home page")
	public void user_is_home_page() {
		try {
			// driver=new ChromeDriver();;
			// Thread.sleep(5000);
			log.debug("url value:" + this.getData("url"));
			getDriver().get(this.getData("url"));
			log.debug("url launched");
			// Thread.sleep(3000);
			getDriver().manage().window().maximize();
			log.debug("Browser got maximized");
			// Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}

	}

	@When("clicks login")
	public void clicks_login() {
		try {
			// Thread.sleep(3000);
			loginPage = new LoginPage(getDriver());
			loginPage.getSignUpAndInBtn().click();
			// getDriver().findElement(By.xpath("//*[text()='Sign In / Sign Up']")).click();
			log.debug("Signup button clicked");
			// Thread.sleep(3000);
			loginPage.getSignInBtn().click();
			// getDriver().findElement(By.xpath("//*[text()='Login']")).click();
			log.debug("Login tab clicked");
			// Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}

	}

	@When("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) {
		try {
			loginPage.getEmail().sendKeys(email);
			// getDriver().findElement(By.xpath("//*[@id='input-Email']")).sendKeys(email);
			log.debug("Email entered:" + email);
			// Thread.sleep(3000);
			loginPage.getPassword().sendKeys(password);
			// getDriver().findElement(By.xpath("//*[@id='input-Password']")).sendKeys(password);
			log.debug("passeord entered:" + password);
			// Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}

	}

	@Then("user is sucessfully logged in")
	public void user_is_sucessfully_logged_in() {
		try {
			Thread.sleep(3000);
			loginPage.getSubmitBtn().click();
			// getDriver().findElement(By.xpath("//*[@type='submit']")).click();
			log.debug("Submit button got clicked");
			Thread.sleep(3000);
			String loginText = loginPage.getLoginText().getText();
			// getDriver().findElement(By.xpath("(//div[@class='relative'])[3]"))
			Assert.assertTrue(loginText.contains("Hi"), "Login failure");
			log.debug("User is logged in successfully");
			// Thread.sleep(3000);
		} catch (Exception ex) {
			log.error("Exception occurred:" + ex.getMessage());
		}
	}

}