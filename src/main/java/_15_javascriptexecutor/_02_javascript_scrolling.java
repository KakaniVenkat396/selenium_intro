package _15_javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _02_javascript_scrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//1) SCROLL DOWN PAGE BY PIXEL NUMBER
		//js.executeScript("window.scrollBy(0, 750)", "");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//2) SCROLL THE PAGE TILL ELEMENT IS VISIBLE
		WebElement slider = driver.findElement(By.cssSelector("span[class*='ui-slider-handle']"));
		//js.executeScript("arguments[0].scrollIntoView();", slider);
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// 3) SCROLL PAGE TILL END OF THE PAGE
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(2000);
		
		// 4) SCROLLING UP TO INITIAL POSITION
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	}
}