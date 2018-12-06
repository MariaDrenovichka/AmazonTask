package core;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;







public class ShoppingCart {

	private static String searchInputId = "twotabsearchtextbox";
	private static String minPriceId = "low-price";
	private static String firstElementXpath = "//*[@class='a-size-base s-inline  s-access-title  a-text-normal'";
	private static String showResultLocator = "//h3[@class='a-size-medium a-spacing-base a-spacing-top-small a-color-tertiary a-text-normal']";

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

	public static void selectFirstItem() {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20); // seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='result_2']")));
		WebElement firstItem = Browser.driver.findElement(By.xpath("//*[@class='s-access-image cfMarker']"));
		String expectedItem = firstItem.getText();															
		firstItem.click();
	}
	
	public static void selectNumberOfItems() {
		String numberOfItems = "option[value='3']";
		WebElement quantity = Browser.driver.findElement(By.xpath("//*[@class='a-dropdown-container']"));
		quantity.click();
		
		Browser.driver.findElement(By.cssSelector(numberOfItems)).click();
//		WebElement selectQuant = Browser.driver.findElement(By.xpath("//*[@tabindex='-1']"));
//		Select numberOfItems = new Select(selectQuant);
////		List <WebElement> list = numberOfItems.getOptions();
////		list.get(2);
//		numberOfItems.selectByIndex(2);
		Browser.driver.findElement(By.id("add-to-cart-button")).click();
	}
	public static void navigateToCart() {
		Browser.driver.findElement(By.id("hlb-view-cart-announce")).click();
	}
    public static void verifyThePurchese() {
	
    	WebElement actualItem = Browser.driver.findElement(By.xpath("//*[@class='a-size-medium sc-product-title a-text-bold']"));
    	Assert.assertEquals(expectedItem, actualItem);
    }
}
