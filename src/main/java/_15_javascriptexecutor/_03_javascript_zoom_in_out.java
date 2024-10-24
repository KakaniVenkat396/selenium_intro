package _15_javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _03_javascript_zoom_in_out {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
		// MINIMIZE THE BROWSER
		driver.manage().window().minimize();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(2000);
		
		// MAXIMIZE THE BROWSER
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// SET ZOOM LEVEL 50%
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(2000);
		
		// SET ZOOM LEVEL 80%
		js.executeScript("document.body.style.zoom='80%'");
	}
}