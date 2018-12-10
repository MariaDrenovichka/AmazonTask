package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import core.Browser;
import core.ShoppingCart;

public class TestShoppingCart extends ShoppingCart{

	@Before
	public void setUp() {
		Browser.start();
		Browser.goTo();
	}

	@Test
	public void compareAddedAndActualItemInTheCart() {
		ShoppingCart.seachAnItem();
		ShoppingCart.selectCategory();
		ShoppingCart.setPriceRange();
		ShoppingCart.waitForElementToPresent();
		ShoppingCart.selectAge();
		ShoppingCart.addFirstItemToCart();
		ShoppingCart.selectQuantity();
		ShoppingCart.navigateToCart();
     	ShoppingCart.checkItemInTheCart();
    	Assert.assertEquals(getExpectedItem(), getActualItem());
    	System.out.println(getExpectedItem());
    	System.out.println(getActualItem());
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
	
}