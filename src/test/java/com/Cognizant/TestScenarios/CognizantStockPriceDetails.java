package com.Cognizant.TestScenarios;

//*******************To import all the required files*******************************//
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cognizant.Pages.ScreenShotPage;
import com.Cognizant.Bases.TestBase;
import com.Cognizant.Pages.CognizantHomePage;
import com.Cognizant.Pages.GoogleStockPage;


//*************************** Creating class ******************************//
public class CognizantStockPriceDetails extends TestBase {

	@Test(priority = 0,groups = { "Smoke" })
	public void getUserInfoTest() {

		/* Creating object for the class CognizantHomePage in Pages Package */
		CognizantHomePage home = new CognizantHomePage();
		
		/* Invoking UserInfo method in CognizantHomePage class */
		home.userInfo();

		String actTitle = driver.getTitle();
		String expTitle = "Be.Cognizant";

		/* Checking whether the actual title and expected title are equal using assert interface */
		Assert.assertEquals(actTitle, expTitle);

	} 
	@Test(priority=1,groups = { "Smoke" })

	public void captureScreenTest() {
		
		/*To capture the output screen*/
		ScreenShotPage screenShot=new ScreenShotPage();
		screenShot.screenShot();
	}
	@Test(priority = 2,groups = { "Smoke" })
	public void getCognizantStockPriceTest() {

		/* Creating object for the class CognizantHomePage in Pages Package */
		CognizantHomePage home = new CognizantHomePage();
		
		/* Get Cognizant Webpage StockPrice */
		home.stockPriceCTSH(); 
	}

	@Test(priority = 3,groups = { "Smoke" })
	public void getGoogleStockPriceTest() {

		/* Creating object for the class GoogleStockPage in Pages Package */
		GoogleStockPage price = new GoogleStockPage();
		
		/* Invoking google method in GoogleStockPage class */
		price.google();

		String actTitle = driver.getTitle();
		String expTitle = "CTS Stock Price - Google Search";

		/* Checking whether the actual title and expected title are equal using assert interface */
		Assert.assertEquals(actTitle, expTitle);
		System.out.println(
				"**********************************************************************************************************************");
		System.out.println("\nThe Title of the Google page is: " + actTitle + "\n");
		System.out.println(
				"**********************************************************************************************************************");
	}
	@Test(priority=4,groups = { "Smoke" })

	public void captureNewWindowScreenTest() {
		
		/*To capture the output screen*/
		ScreenShotPage screenShot=new ScreenShotPage();
		screenShot.screenShot();
	}

	@Test(priority = 5,groups = { "Smoke" })
	public void compareStockPriceTest() {
		
		/* Creating object for the class GoogleStockPage in Pages Package */
		GoogleStockPage price = new GoogleStockPage();
		
		/* Invoking check method in GoogleStockPage class */	
		price.check();
 
	}
}
