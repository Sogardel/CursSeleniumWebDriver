package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class DataProviderLoginTest extends BaseTest {

	
	@DataProvider(name = "loginTestData")
	public Object[][] loginTestData(){
		
		Object data[][] = new Object[4][3];
		
		//username 						//password								//boolean
		data[0][0] = "TestUser"; 		data[0][1] = "12345@67890";       data[0][2] = true;
		data[1][0] = "userGresit";		data[1][1] = "000000";			  data[1][2] = false;		
		data[2][0] = "test.test";       data[2][1] = "test.test@123";     data[2][2] = true;
		data[3][0] = "userGresit";		data[3][1] = "000000";			  data[3][2] = false;		

		return data;
	}
	
	
	@Test(dataProvider = "loginTestData")
	public void loginTests(String username, String password, boolean sucess) {	 
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp(username, password);
		
		if(sucess) {
			//assertEquals(navMenu.getLoggedUser(), "Test User");
			assertTrue(loginPage.loginSuccessIsDisplayed());
			loginPage.logoutFromApp();
		}else  {
			assertTrue(loginPage.loginErrorIsDisplayed());
			loginPage.closePopUp();

		}


		
	}
	
	
}
