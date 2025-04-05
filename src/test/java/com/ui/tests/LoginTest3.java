package com.ui.tests;


import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest3 extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	
	@Test(description = "Verify with valid credentials, user is able to login to application", groups = {"E2E","Sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {//Json file
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Brocode Lee");
	}
	
	@Test(description = "Verify with valid credentials, user is able to login to application", groups = {"E2E","Sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Brocode Lee");
	}
	
	@Test(description = "Verify with valid credentials, user is able to login to application", groups = {"E2E","Sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Brocode Lee");

	}
	
	

}
