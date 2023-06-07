package com.qa.opencart.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	//1. const. of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//2. private By locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdlink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	
	
	//3. public page actions/methods:
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("login page title : " + title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("login page url : " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdlink).isDisplayed();
	}
	
	public List<String> getFooterLinksList() {
		List<WebElement> footerLinksList = driver.findElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();
		for(WebElement e : footerLinksList) {
			String text = e.getText();
			footerTextList.add(text);
		}
		return footerTextList;
	}
	
	public void doLogin(String userName, String pwd) {
		driver.findElement(emailId).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		//return the next landing page -- AccountsPage -- page chaining model
	}

}
