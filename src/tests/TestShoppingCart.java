package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import core.Browser;
import core.ShoppingCart;

public class TestShoppingCart {

	@Before
	public void setUp() {
		Browser.start();
	}

	@Test
	public void compareSelectedAndTheItemInTheCart() {
		Browser.goTo();
		ShoppingCart.seachAnItem();
		ShoppingCart.selectCategory();
		ShoppingCart.setPriceRange();
		ShoppingCart.waitForElementToPresent();
		ShoppingCart.selectAge();
		ShoppingCart.addFirstItemToCart();
		ShoppingCart.selectQuantity();
		ShoppingCart.navigateToCart();
     	ShoppingCart.verifyCorrectItemIsInTheCart();
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
	
}