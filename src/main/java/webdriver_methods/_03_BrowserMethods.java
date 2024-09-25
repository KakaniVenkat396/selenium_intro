package webdriver_methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _03_BrowserMethods {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		link.click(); // this will opens new browser window
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		// close() -  single browser window where ever the driver is focused
		if(null != driver) {
			//driver.close();
		}
		
		// quit() -  // close all the browser windows opened by script
		if(null != driver) {
			driver.quit();
		}
	}
}