package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;


public class LoginTest {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();// launch a brower window
		
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizewindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign')]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator= By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "kcgbhrk683@tempimail.org");
		
		By passwordTextBoxLocator= By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "Brocode@05");
		
		By submitLoginButtonLocator= By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);
		
	
	}

}
