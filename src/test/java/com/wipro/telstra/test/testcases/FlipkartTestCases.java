package com.wipro.telstra.test.testcases;

/* Automation of Flipkart Web Application 
 * Author : Maniakndan K
 * Date : 31/07/2019
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.wipro.telstra.driverSetup.BaseTestPage;
import com.wipro.telstra.test.pageObjects.FlipkartDetailsPage;
import com.wipro.telstra.test.pageObjects.FlipkartHomePage;
import com.wipro.telstra.test.pageObjects.FlipkartLoginPage;
import com.wipro.telstra.test.pageObjects.FlipkartMyCartPage;
import com.wipro.telstra.test.utility.CommonMethods;
import com.wipro.telstra.test.utility.TelstraVerification;

public class FlipkartTestCases extends BaseTestPage {

	public WebElement element;
	
	// Test case to verify login
	@Test(priority = 1)
	public void tc_loginToFlipkart() throws Exception {
		FlipkartLoginPage flipkartLoginPage = new FlipkartLoginPage(driver);
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
		flipkartLoginPage.login(userName, passWord);
		TelstraVerification.verifyElementPresent(driver, flipkartHomePage.labelMyAccounts); 
		
	}
	
	//Test case to move item to cart and verify the details in search screen and checkout screen
	@Test
	public void tc_moveItemToCart() throws Exception {
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
		FlipkartLoginPage flipkartLoginPage = new FlipkartLoginPage(driver);
		FlipkartDetailsPage flipkartDetailsPage = new FlipkartDetailsPage(driver);
		FlipkartMyCartPage flipkartMyCartPage = new FlipkartMyCartPage(driver);
		flipkartLoginPage.login(userName, passWord);
		flipkartHomePage.textBoxSearch.sendKeys("Camera");
		flipkartHomePage.buttonSearchIcon.click();
		Thread.sleep(2000);
		CommonMethods.scrollToWebElement(driver, flipkartHomePage.cameraLink);
		Thread.sleep(2000);
		ArrayList<String> actDataSearchScreen = new ArrayList<String>();
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Effective Pixels: 20.1 MP").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Optical Zoom: 6 | Digital Zoom: 12x").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Auto Focus").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Display Size: 3.2").getText());
		flipkartHomePage.cameraLinkClick.click();
		Thread.sleep(3000);
		String parentWinHandle = driver.getWindowHandle();
		Set<String> openWindows = driver.getWindowHandles();
		for (String handle : openWindows) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}
		System.out.println("New Tab : " + driver.getTitle());
		TelstraVerification.verifyImagePresentOrNot(driver, flipkartDetailsPage.imageCamera);
		CommonMethods.scrollToWebElement(driver, flipkartDetailsPage.labelHighlights);
		ArrayList<String> dataCheckoutScreen = new ArrayList<String>();
		List<WebElement> actualHeaders = flipkartDetailsPage.dataCheckoutScreen;
		for (WebElement headers : actualHeaders) {

			dataCheckoutScreen.add(headers.getText());
		}
		TelstraVerification.verifyTwoLists(actDataSearchScreen, dataCheckoutScreen);
		Thread.sleep(2000);
		flipkartDetailsPage.buttonAddToCart.click();
		TelstraVerification.verifyElementPresent(driver, flipkartMyCartPage.labelCameraName);
		TelstraVerification.verifyElementPresent(driver, flipkartMyCartPage.buttonPlaceOrder);
		
		
	}
	
	// Test case to verify checkout screen
	@Test
	public void tc_checkoutItem() throws Exception {
		
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
		FlipkartLoginPage flipkartLoginPage = new FlipkartLoginPage(driver);
		FlipkartMyCartPage flipkartMyCartPage = new FlipkartMyCartPage(driver);
		flipkartLoginPage.login(userName, passWord);
		flipkartHomePage.buttonCart.click();
		TelstraVerification.verifyElementPresent(driver, flipkartMyCartPage.labelCameraName);
		TelstraVerification.verifyElementPresent(driver, flipkartMyCartPage.buttonPlaceOrder);
		
	}

}
