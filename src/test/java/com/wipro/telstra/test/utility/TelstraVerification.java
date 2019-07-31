package com.wipro.telstra.test.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.wipro.telstra.driverSetup.BasePage;

public class TelstraVerification extends BasePage {

	public TelstraVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void verifyElementPresent(WebDriver driver, WebElement locator) throws Exception {
		try {

			if (locator.isDisplayed()) {

				System.out.println(locator.getAttribute("class") + "PASS Element is Displayed");
			}

		} catch (NoSuchElementException error) {

			throw new Exception(locator.getAttribute("value") + "Element is not Displayed");

		}

	}

	public static void verifyImagePresentOrNot(WebDriver driver, WebElement imageLocator) {
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				imageLocator);
		int logoWidth = imageLocator.getSize().getWidth();
		System.out.println("Logo width : " + logoWidth + " pixels");
		int logoHeight = imageLocator.getSize().getHeight();
		System.out.println("Logo height : " + logoHeight + " pixels");
		if (!ImagePresent) {
			Reporter.log("FAIL Image not displayed ");
		} else {
			Reporter.log("PASS : Image is displayed ");
		}

	}

	// Comparing two lists
	public static void verifyTwoLists(List actList, List expList) {
		if (actList.equals(expList)) {
			System.out.println("PASS : All elements present " + expList.toString());
		} else {
			System.out.println(
					"PASS : All elements present Actual List :" + actList.toString() + "\n Expected List" + expList);
		}
	}

}
