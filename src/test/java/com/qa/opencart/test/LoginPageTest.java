package com.qa.opencart.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.pages.LoginPage;


public class LoginPageTest {
	
	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test
	public void loginPageUrlTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains("route=account/login"));
	}

	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
