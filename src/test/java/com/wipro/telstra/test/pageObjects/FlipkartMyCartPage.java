package com.wipro.telstra.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.driverSetup.BasePage;

public class FlipkartMyCartPage extends BasePage{

	public FlipkartMyCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@href='/']")
	public WebElement new1;
	
	//Xpath for the camera label
	@FindBy(xpath = "//a[text()='Sony CyberShot DSC-W800/SC IN5']")
	public WebElement labelCameraName;
	
	//Xpath for Place order button
	@FindBy(xpath = "//span[text()='Place Order']")
	public WebElement buttonPlaceOrder;
}
