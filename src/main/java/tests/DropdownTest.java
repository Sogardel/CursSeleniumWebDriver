package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ShopPage;
import utils.BaseTest;

public class DropdownTest extends BaseTest {
	
	
	@Test(groups = "ProductFunctionality")
	public void dropdownFilterByValueExample() {
		ShopPage shopPage =  navMenu.navToShop();
		shopPage.filterByValue("popularity");
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by popularity4");	
		
	}
	
	@Test(groups = "ProductFunctionality")
	public void dropdownFilterByIndexExample() {
		ShopPage shopPage =  navMenu.navToShop();
		shopPage.filterByIndex(3);
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by latest2");	
	}
	
	@Test(groups = "ProductFunctionality")
	public void dropdownFilterByVisibleTextExample() {
		ShopPage shopPage =  navMenu.navToShop();
		shopPage.filterByVisibleText("Sort by price: high to low");
		assertEquals(shopPage.getCurrentSelectedOption(), "Sort by price: high to low5");
	}
	

}
