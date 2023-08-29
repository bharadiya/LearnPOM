package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Login;
import Utility.ReadConfigurationFile;

public class TestOnFB {
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\poona\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	}
	public static WebDriver driver = new ChromeDriver();
	static ReadConfigurationFile rc = new ReadConfigurationFile("C:\\Users\\poona\\eclipse-workspace\\LearnPOM\\src\\ExternalDependancies\\config.properties");
	static Login l = new Login(driver);

	@BeforeTest
	public static void openBrowserAndLaunchURL() {
		driver.get(rc.getApplicationURL());
	}

	@Test(priority = 1)
	public static void fetchTitle() throws InterruptedException {
		String currentTitle = driver.getTitle();
		boolean b = currentTitle.equals(rc.getTitle());
		System.out.println(b);
		Assert.assertTrue(b);
	}

	@Test(priority = 2)
	public static void checkForgottenPasswordLink() {
		l.enterUserName(rc.getUserName());
		l.enterPassword(rc.getPassword());
		l.clickForgottenPassword();
		String s = driver.getCurrentUrl();
		Assert.assertTrue(s.equals(rc.getForgottenPasswordLink()));
	}
}
