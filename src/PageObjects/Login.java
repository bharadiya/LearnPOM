package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public static WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@id='user-name']")
	WebElement username;

	@FindBy(how = How.ID, using = "password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//a[text()='Forgotten password?']")
	WebElement forgottenPassword;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userDetails) {
		username.sendKeys(userDetails);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickForgottenPassword() {
		forgottenPassword.click();
	}
}
