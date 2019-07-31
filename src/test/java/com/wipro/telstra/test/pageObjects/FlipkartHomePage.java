package com.wipro.telstra.test.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.driverSetup.BasePage;

public class FlipkartHomePage extends BasePage {

	public FlipkartHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	// Xpath for the Login button
	@FindBy(xpath = "//*[@href='/account/login?ret=/']")
	public WebElement buttonLoginSignUp;

	// Xpath for the search in home screen
	@FindBy(xpath = "//input[@class='LM6RPg']")
	public WebElement textBoxSearch;

	// Xpath for the search icon
	@FindBy(xpath = "//button[@class='vh79eN']")
	public WebElement buttonSearchIcon;

	// Xpath for a random camera link
	@FindBy(xpath = "//div[text()='Sony CyberShot DSC-W800/SC IN5']")
	public WebElement cameraLink;
	
	//Xpath for the link
	@FindBy(xpath = "//div[@data-id='CAMDVGUGJ4G5FVDM']")
	public WebElement cameraLinkClick;
	
	public WebElement dataCheck(WebDriver driver, String data) {
		return driver.findElement(By.xpath("//li[text()='"+ data+ "']"));
	}
	
	//Xpath for the My Accounts
	@FindBy(xpath = "//*[@class='_2aUbKa']")
	public WebElement labelMyAccounts;
	
	//Xpath for Cart
	@FindBy(xpath = "//span[text()='Cart']")
	public WebElement buttonCart;
	
	//Xpath for logout button
	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	public WebElement buttonLogout;
	

}