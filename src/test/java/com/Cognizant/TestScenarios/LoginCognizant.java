package com.Cognizant.TestScenarios;

//******************* To import all the required files *******************************//
import org.testng.Assert;
import org.testng.annotations.*;

import com.Cognizant.Bases.TestBase;
import com.Cognizant.Pages.CognizantLoginPage;

//*************************** Creating class ******************************//
public class LoginCognizant extends TestBase {

	@BeforeClass(groups = { "BaseMethods" })
	public void beforeClass() throws InterruptedException {

		/* Invoking setupDriver and navigateToURL methods from TestBase class */
		setupDriver();
		navigateToURL();
		String actTitle = driver.getTitle();
		String expTitle ="Sign in to your account";

		/* Checking whether the actual title and expected title are equal using assert */
		Assert.assertEquals(actTitle, expTitle);
	}

	@Test(priority = 0,groups = { "BaseMethods" })
	public void setUserIdTest() {
	
		/* Creating object for the class CognizantLoginPage in Pages Package */
		CognizantLoginPage login = new CognizantLoginPage();
		
		/* Invoking enterUserId method in CognizantLoginPage class */
		login.enterUserId();
	} 

	@Test(priority = 1,groups = { "BaseMethods" })
	public void setPasswordTest() {

		/* Creating object for the class CognizantLoginPage in Pages Package */
		CognizantLoginPage login = new CognizantLoginPage();
		
		/* Invoking enterPassword method in CognizantLoginPage class */
		login.enterPassword();	
	}

	@Test(priority = 2,groups = { "BaseMethods" })
	public void approvalTest() {
		
		/* Creating object for the class CognizantLoginPage in Pages Package */
		CognizantLoginPage login = new CognizantLoginPage();
		
		/* Invoking selectApproval and verifyId methods in CognizantLoginPage class */
		login.selectApproval();
		login.verifyId();
	}

}