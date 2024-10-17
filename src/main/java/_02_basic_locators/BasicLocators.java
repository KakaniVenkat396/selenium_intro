package _02_basic_locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BasicLocators {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		// Name locator
		driver.findElement(By.name("search")).sendKeys("MacBook");
		
		// ID locator
		boolean status = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(status);
		
		// LinkText Locator
		//driver.findElement(By.linkText("Tablets")).click();
		
		// Partical LinkText Locator
		//driver.findElement(By.partialLinkText("Table")).click();
	
		// ClassName Locator - Mostly used for identify multiple web elements
		driver.findElement(By.className("input-group-btn")).click();
	
		// TagName Locator - Mostly used for identify multiple web elements
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		/*
		 * 	Diff b/w findElement(loc) Vs findElements(loc)

			Scenario1: Locator is smatching with single web element
			findElement(loc) ----> single web element ---> WebElement
			findElements(loc) ---> single web element ----> List<WebElement>

			Sceanrio2 : Locator is matching with multiple web elements
			findElement(loc) ---> single web element --> WebElement
			findElements(loc) ---> multiple web elements ---> List<WebElement>

			Scenario3: Locator is not matching with any element.
			findElement(loc) ----> NosuchElementException
			findElements(loc)----->will not throw any exception. Returns 0
		 */
	}
}