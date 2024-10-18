package _05_webdriver_methods_1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_GetAndBrowserMethods {
	
	// get methods - we can access these methods through webdriver instance

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// 1. get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// 2. getTitle() - returns title of the page
		String title = driver.getTitle();
		System.out.println(title);
		
		// 3. getCurrentUrl() - retuns URL of the page
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		// 4. getPageSource()- returns source code of the page
		String pageSource = driver.getPageSource();
		
		// 5. getWindowHandle() - returns ID of the single Browser window
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);
		
		// 6. getWindowHandles() - retuns ID's of the multiple browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		// 7. close() - close single browser
		driver.close();
		
		// 8. quit() - close multiple browsers
		driver.quit();
	}
}