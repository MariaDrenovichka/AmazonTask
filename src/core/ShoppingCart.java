package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	private static String searchInputId = "twotabsearchtextbox";
	private static String minPriceId = "low-price";
	private static String showResultLocator = "//h3[@class='a-size-medium a-spacing-base a-spacing-top-small a-color-tertiary a-text-normal']";
	private static String expectedItem;
	private static String actualItem;

	public static void seachAnItem() {
		WebElement searchFor = Browser.driver.findElement(By.id(searchInputId));
		searchFor.click();
		searchFor.sendKeys("Harry Potter");
		Browser.driver.findElement(By.name("site-search")).submit();
	}

	public static void selectCategory() {
		Browser.driver.findElement(By.xpath("//*[contains(text(), 'See All 37 Departments')]")).click();
		WebElement scrollToElement = Browser.driver.findElement(By.xpath("//li[7]/span/a/h4"));
		JavascriptExecutor js = (JavascriptExecutor) Browser.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		scrollToElement.click();
	}

	public static void setPriceRange() {
		WebElement minPrice = Browser.driver.findElement(By.id(minPriceId));
		WebElement maxPrice = Browser.driver.findElement(By.id("high-price"));
		WebElement submitButton = Browser.driver.findElement(By.cssSelector(".a-spacing-top-mini .a-button-input"));
		minPrice.click();
		minPrice.sendKeys("10");
		maxPrice.click();
		maxPrice.sendKeys("150");
		submitButton.click();
	}

	public static void waitForElementToPresent() {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(showResultLocator)));
	}

	public static void selectAge() {
		WebElement above14 = Browser.driver.findElement(By.name("s-ref-checkbox-5442388011"));
		above14.click();
	}

	public static void addFirstItemToCart() {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='result_2']")));
		WebElement firstItem = Browser.driver.findElement(By.xpath("//*[@class='s-access-image cfMarker']"));
		firstItem.click();

		WebElement selectedItem = Browser.driver.findElement(By.id("productTitle"));
		expectedItem = selectedItem.getText();
	}

	public static void selectQuantity() {
		String numberOfItems = "option[value='2']";
		String addToCartId = "add-to-cart-button";

		if (Browser.driver.findElements(By.xpath("//*[@class='a-dropdown-container']")).isEmpty()) {
			Browser.driver.findElement(By.id(addToCartId)).click();
		} else {
			WebElement quantity = Browser.driver.findElement(By.xpath("//*[@class='a-dropdown-container']"));
			quantity.click();
			Browser.driver.findElement(By.cssSelector(numberOfItems)).click();
			Browser.driver.findElement(By.id(addToCartId)).click();
		}
	}

	public static void navigateToCart() {
		Browser.driver.findElement(By.id("hlb-view-cart-announce")).click();
	}

	public static void verifyCorrectItemIsInTheCart() {

		WebElement itemInTheCard = Browser.driver
				.findElement(By.xpath("//*[@class='a-size-medium sc-product-title a-text-bold']"));
		actualItem = itemInTheCard.getText();
		Assert.assertEquals(expectedItem, actualItem);
	}
}
