package com.Cognizant.Pages;

//*******************To import all the required files*******************************//
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cognizant.Bases.TestBase;

//*************************** Creating class ******************************//
public class CognizantHomePage extends TestBase {

	 /* To initialize the locater variable with the type */
	public static String price;

	By userinfo = By.xpath("//*[@id=\"user-name\"]");

	By stockLocator = By.xpath("//*[@class=\"ng-isolate-scope\"]/div/header-stock-ticker/div/div[2]/span");

	By windowicon = By.xpath("//*[@id=\"header-menu-item-AppsAndTools-header-menu-button\"]/button");

	By myappsLocator = By.xpath(
			"//*[@id=\"header-menu-item-AppsAndTools\"]/apps-and-tools/div/div/div/div/tabset/div/div/button[1]");

	By myappsanameLocator = By.xpath("//*[@id=\"mCSB_2_container\"]/div[1]");

	By office360Locator = By.xpath(
			"//*[@id=\"header-menu-item-AppsAndTools\"]/apps-and-tools/div/div/div/div/tabset/div/div/button[2]");

	By officeappsnameLocator = By.xpath("//*[starts-with(@id,'mCSB')]/div/div/apps-and-tools-tab-item/div/a/span[2]");

	By companyappsLocator = By.xpath(
			"//*[@id=\"header-menu-item-AppsAndTools\"]/apps-and-tools/div/div/div/div/tabset/div/div/button[3]");

	By companyappsnameLocator = By.xpath("//*[starts-with(@id,'mCSB')]/div/div/apps-and-tools-tab-item/div/a/span[2]");

	WebDriverWait wait = new WebDriverWait(driver, 40);

	By wait1 = By.xpath("//*[@class='img-responsive']");

	By wait2 = By.xpath(
			"//*[@id=\"header-menu-item-AppsAndTools\"]/apps-and-tools/div/div/div/div/tabset/div/div/button[1]");

	By wait3 = By.xpath("//*[text()='Welcome Center']");

	By wait4 = By.xpath("//*[text()='Microsoft Teams']");

	//****************************** To create method to get user information ***********************************//
	public void userInfo() {

		
		/* Explicit wait */
		wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));

		/* Get User Information */
		String name = driver.findElement(userinfo).getText();
		System.out.println(
				"**********************************************************************************************************************");
		System.out.println("\nThe Name of User Loggedin : " + name + "\n");
		System.out.println(
				"**********************************************************************************************************************");
	}

	//****************************** To create method to get CTSH Price in Be.Cognizant ***********************************//
	public void stockPriceCTSH() {

		/* Get CTSH Price in Be.Cognizant */
		price = driver.findElement(stockLocator).getText();

		System.out.println("\nCognizant Site : CTSH Price is " + price);

	}
	
	//****************************** To create method to switch to apps and tools ***********************************//
	public void selectWindowIcon() {

		/* Select Apps and Tools Window Icon */

		driver.findElement(windowicon).click();

		/* Explicit wait */
		wait.until(ExpectedConditions.visibilityOfElementLocated(wait2));
	} 

	//****************************** To create method to switch to apps and tools ***********************************//
	public void displayAppsName(String GetAppName) {

		// *********** Display Apps Name Under Various Category *********** //

		if (GetAppName.equalsIgnoreCase("COMPANY APPS")) {

			driver.findElement(companyappsLocator).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(wait3));

			System.out.println("\nCOMPANY APPS : "+"\n");

			List<WebElement> ul = driver.findElements(companyappsnameLocator);

			for (WebElement ele1 : ul) {
				String Apps = ele1.getText();

				System.out.println(Apps);

			}
		} else if (GetAppName.equalsIgnoreCase("OFFICE 365 APPS")) {

			driver.findElement(office360Locator).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(wait4));

			System.out.println("\nOFFICE 365 APPS : "+"\n");

			List<WebElement> ul = driver.findElements(officeappsnameLocator);

			for (WebElement ele1 : ul) {
				String app = ele1.getText();

				System.out.println(app);

			}
		} else if (GetAppName.equalsIgnoreCase("MY APPS")) {

			System.out.println("\nMY APPS : "+"\n");

			driver.findElement(myappsLocator).click();

			String app = driver.findElement(myappsanameLocator).getText();

			System.out.println(app);

		}

	}
}
