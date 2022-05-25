package com.Cognizant.Pages;

//******************* To import all the required files *******************************//
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cognizant.Bases.TestBase;

//*************************** Creating class ******************************//
public class CognizantLoginPage extends TestBase {

	 /* To initialize the locater variable with the type */
	By userid = By.name("loginfmt");

	By usersubmit = By.xpath("//*[@type=\"submit\"]");

	By userpassword = By.name("passwd");

	By calloption = By.xpath("//*[@class=\"form-group\"]/div[2]");

	WebDriverWait wait = new WebDriverWait(driver, 40);

	By wait1 = By.xpath("//*[@id=\"idBtn_Back\"]");

	//****************************** To create method to enter user email id ***********************************//
	public void enterUserId() {

		/* Enter UserId */

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(userid).sendKeys("2150269@cognizant.com");

		/* Wait for 2 sec */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(usersubmit).click();
	}

	//****************************** To create method to enter password ***********************************//
	public void enterPassword() {

		/* Wait for 2 sec */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Enter the Password*/
		driver.findElement(userpassword).sendKeys("Bull@2000");

		/* Wait for 2 sec */	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* To click on submit */
		driver.findElement(usersubmit).click();
	}

	//****************************** To create method to click on call option ***********************************//
	public void selectApproval() {

		/* Verify by Call Option*/
		driver.findElement(calloption).click();

		/* Explicit Wait */
		wait.until(ExpectedConditions.visibilityOfElementLocated(wait1));
	}


	//****************************** To create method to click on stay signed in option ***********************************//
	public void verifyId() {

		/* Stay in Option*/
		driver.findElement(usersubmit).click();
		
		/* Implicit wait */
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
	}
	

}
