package com.Cognizant.Pages;

//*******************To import all the required files*******************************//
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cognizant.Bases.TestBase;

//*************************** Creating class ******************************//
public class GoogleStockPage extends TestBase {

	 /* To initialize the locater variable with the type */
	public static ArrayList<String> tabs;
	
	static String price1;

	By searchLocator = By.xpath("//*[@aria-label=\"Search\"]");

	By stockpriceLocator = By.xpath(
			"//*[@id=\"knowledge-finance-wholepage__entity-summary\"]/div/g-card-section/div/g-card-section/div[2]/div[1]/span[1]/span/span[1]");

	WebDriverWait wait = new WebDriverWait(driver, 40);

	//****************************** To create method to Open New Window ***********************************//
	public void google() {

		/* Open New Window in Browser */

		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String>(driver.getWindowHandles());

		/* Switch to new Window */

		driver.switchTo().window(tabs.get(1));

		driver.get("https://www.google.com/");

		/* Get CTSH Price in Google */

		driver.findElement(searchLocator).sendKeys("CTS Stock Price");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(searchLocator).sendKeys(Keys.ENTER);

		/* Explicit wait */
		wait.until(ExpectedConditions.visibilityOfElementLocated(stockpriceLocator));

		price1 = driver.findElement(stockpriceLocator).getText();
		System.out.println("\n**********************************************************************************************************************\n");
		System.out.println("Google Site : CTSH Price is " + price1+"\n");

	}

	//****************************** To create method to compare CTSH price***********************************//
	public void check() {

		CognizantHomePage stock = new CognizantHomePage();
		String CTSH = stock.price;

		// ********** Compare CTSH Price *********** //

		if (CTSH.equals(price1)) {

			System.out.println("\nCTSH " + CTSH + " is Same in Both in Cognizant and Google\n");
			System.out.println(
					"**********************************************************************************************************************");
		} else {
			System.out.println("\nCTSH " + CTSH + " is Not Same in Both in Cognizant and Google\n");
			System.out.println(
					"**********************************************************************************************************************");
		}

		// ********** Switch To Parent Window *********** //

		driver.switchTo().window(tabs.get(0));
	}
}
