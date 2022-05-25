package com.Cognizant.TestScenarios;

//*******************To import all the required files*******************************//
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;
import com.Cognizant.Bases.TestBase;
import com.Cognizant.Pages.CognizantHomePage;
import com.Cognizant.Pages.ScreenShotPage;
import com.Cognizant.Utils.ExcelUtils;

//*************************** Creating class ******************************//
public class CognizantAppsAndTools extends TestBase {

	@Test(priority = 0,groups = { "Regression" })
	public void setWindowTest() {
		
		/* Creating object for the class CognizantHomePage in Pages Package */
		CognizantHomePage home = new CognizantHomePage();
		
		/* Invoking selectWindowIcon method in CognizantHomePage class */
		home.selectWindowIcon();

		String actTitle = driver.getTitle();
		String expTitle = "Be.Cognizant";

		/* Checking whether the actual title and expected title are equal using assert interface */

		Assert.assertEquals(actTitle, expTitle);

	}

	@Test(priority=1,groups = { "Regression" })

	public void captureScreenTest() {
		
		/*To capture the output screen*/
		ScreenShotPage screenShot=new ScreenShotPage();
		screenShot.screenShot();
	}
	
	@DataProvider
	public Object[][] dp() throws IOException {
		Object[][] obj = new Object[1][1];
		obj = ExcelUtils.readExcelData();
		return obj;
	}

	@Test(priority = 2, dataProvider = "dp",groups = { "Regression" })
	public void getAppsAndToolsTest(String GetAppName) {

		/* Creating object for the class CognizantHomePage in Pages Package */
		CognizantHomePage home = new CognizantHomePage();
		
		/* Invoking displayAppsName method in CognizantHomePage class */
		home.displayAppsName(GetAppName);
	}


	@Test(priority=3,groups = { "Regression" })

	public void captureAppsAndToolsTest() {
		
		/*To capture the output screen*/
		ScreenShotPage screenShot=new ScreenShotPage();
		screenShot.screenShot();
	}
	@AfterClass(groups = { "Regression" })
	public void afterClass() {

		/*Invoking closeDriver method TestBase class*/
		closeDriver();
	} 
}
