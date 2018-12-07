package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.google.common.base.Verify;

import core.Browser;
import core.ShoppingCart;

public class TestShoppingCart {

	@Before
	public void setUp() {
		Browser.start();
	}

	@Test
	public void searchForAnItem() {
		Browser.goTo();
		ShoppingCart.seachAnItem();
		ShoppingCart.selectCategory();
		ShoppingCart.setPriceRange();
		ShoppingCart.waitForElementToPresent();
		ShoppingCart.selectAge();
		ShoppingCart.addFirstItemToCart();
//		ShoppingCart.selectNumberOfItems();
	}

//	@After
//	public void tearDown() {
//		Browser.quit();
//	}
}