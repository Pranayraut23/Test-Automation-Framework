package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;


public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();// launch a brower window
		HomePage homePage = new HomePage(wd);
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("kcgbhrk683@tempimail.org", "Brocode@05");
	
	}

}
