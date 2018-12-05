package core;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

	public static WebDriver driver;

	public static void start() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void quit() {
		driver.quit();
	}

	public static void goTo() {
		Browser.driver.get("https://www.amazon.com");
	}

	public static void waitForMe() {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
	}
}