package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
	private static String expectedItem;
	private static String actualItem;

	public static void seachAnItem() {
		String searchInputId = "twotabsearchtextbox";

		WebElement searchFor = Browser.driver.findElement(By.id(searchInputId));
		searchFor.click();
		searchFor.sendKeys("Harry Potter");
		Browser.driver.findElement(By.name("site-search")).submit();
	}

	public static void selectCategory() {
		String departmentsLocator = "//*[contains(text(), 'See All 37 Departments')]";
		String toysAndGameLocator = "//li[7]/span/a/h4";
		
		Browser.driver.findElement(By.xpath(departmentsLocator)).click();
		WebElement scrollToElement = Browser.driver.findElement(By.xpath(toysAndGameLocator));
		JavascriptExecutor js = (JavascriptExecutor) Browser.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		scrollToElement.click();
	}

	public static void setPriceRange() {
		String goButtonLocator = ".a-spacing-top-mini .a-button-input";

		WebElement minPrice = Browser.driver.findElement(By.id("low-price"));
		WebElement maxPrice = Browser.driver.findElement(By.id("high-price"));
		WebElement submitButton = Browser.driver.findElement(By.cssSelector(goButtonLocator));
		minPrice.click();
		minPrice.sendKeys("10");
		maxPrice.click();
		maxPrice.sendKeys("150");
		submitButton.click();
	}

	public static void waitForElementToPresent() {
		String showResultLocator = "//h3[@class='a-size-medium a-spacing-base a-spacing-top-small a-color-tertiary a-text-normal']";

		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(showResultLocator)));
	}

	public static void selectAge() {
		WebElement above14 = Browser.driver.findElement(By.name("s-ref-checkbox-5442388011"));
		above14.click();
	}

	public static void addFirstItemToCart() {
		String firstItemLocator = "//*[@class='s-access-image cfMarker']";
		
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='result_2']")));
		WebElement firstItem = Browser.driver.findElement(By.xpath(firstItemLocator));
		firstItem.click();
		WebElement selectedItem = Browser.driver.findElement(By.id("productTitle"));
		setExpectedItem(selectedItem.getText());
	}

	public static void selectQuantity() {
		String quantityOptionLocator = "//*[@class='a-dropdown-container']";
		String selectTwoItemsLocator = "option[value='2']";
		String addToCartId = "add-to-cart-button";

		if (Browser.driver.findElements(By.xpath(quantityOptionLocator)).isEmpty()) {
			Browser.driver.findElement(By.id(addToCartId)).click();
		} else {
			WebElement quantity = Browser.driver.findElement(By.xpath(quantityOptionLocator));
			quantity.click();
			Browser.driver.findElement(By.cssSelector(selectTwoItemsLocator)).click();
			Browser.driver.findElement(By.id(addToCartId)).click();
		}
	}

	public static void navigateToCart() {
		Browser.driver.findElement(By.id("hlb-view-cart-announce")).click();
	}

	public static void checkItemInTheCart() {
		String addedItemLocator = "//*[@class='a-size-medium sc-product-title a-text-bold']";
		
		WebElement itemInTheCard = Browser.driver.findElement(By.xpath(addedItemLocator));
		setActualItem(itemInTheCard.getText());
	}

	public static String getExpectedItem() {
		return expectedItem;
	}

	public static void setExpectedItem(String expectedItem) {
		ShoppingCart.expectedItem = expectedItem;
	}

	public static String getActualItem() {
		return actualItem;
	}

	public static void setActualItem(String actualItem) {
		ShoppingCart.actualItem = actualItem;
	}
}
