package com.wipro.telstra.test.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.driverSetup.BasePage;

public class FlipkartDetailsPage extends BasePage{

	public FlipkartDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Xpath for the camera image
		@FindBy(xpath = "//div[@class='_3BTv9X _3iN4zu']/img")
		public WebElement imageCamera;
		
		//Xpath for the data in checkout screen
		@FindBy(xpath = "//div[@class='_3WHvuP']/ul")
		public List<WebElement> dataCheckoutScreen;
		
		//Xpath for the data section
		@FindBy(xpath = "//div[text()='Highlights']")
		public WebElement labelHighlights;
		
		//Xpath for the Add to cart
		@FindBy(xpath = "//button[text()='ADD TO CART']")
		public WebElement buttonAddToCart;

}
