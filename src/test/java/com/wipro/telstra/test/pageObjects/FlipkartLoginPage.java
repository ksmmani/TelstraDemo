package com.wipro.telstra.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.driverSetup.BasePage;

public class FlipkartLoginPage extends BasePage{

	public FlipkartLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Xpath for the email/phone number input
		@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
		public WebElement inputEmail;

		// Xpath for the password
		@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
		public WebElement inputPassword;

		// Xpath for the login button
		@FindBy(xpath = "//button//span")
		public WebElement buttonLogin;

		public void login(String userName, String passWord) throws InterruptedException {

			inputEmail.sendKeys(userName);
			inputPassword.sendKeys(passWord);
			buttonLogin.click();
			Thread.sleep(5000);
		}

}
