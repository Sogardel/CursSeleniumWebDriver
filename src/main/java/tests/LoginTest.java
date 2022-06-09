package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	
	@Parameters({"user", "pass"})
	@Test(groups = "LoginFunctionality" ,priority = 0)
	public void loginTest(String username, String password) {
		 
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp(username, password);
		assertEquals(navMenu.getLoggedUser(), "Test User");
		loginPage.logoutFromApp();
	
	}

	@Parameters({"invalidUser", "invalidPass"})
	@Test(groups = "LoginFunctionality",priority = 1)
	public void invalidLoginTest(String username, String password) {
	
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp(username, password);
		assertTrue(loginPage.loginErrorIsDisplayed());
	}

}
