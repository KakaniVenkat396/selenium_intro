package webdriver_methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_GetMethods {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//getTitle() - returns title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		
		//getCurrentUrl() - retuns URL of the page
		String url = driver.getCurrentUrl();
		System.out.println("Url of the page: "+url);
		
		//getPageSource()- returns source code of the page
		String pageSource = driver.getPageSource();
		System.out.println("Page Source: "+pageSource);
		
		//getWindowHandle() - returns ID of the single Browser window
		String windowId = driver.getWindowHandle();
		System.out.println("The current browser id is: "+windowId);
		
		//getWindowHandles() - retuns ID's of the multiple browser windows
		WebElement link = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		link.click(); // this will opens new browser window
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		if(null != driver) {
			driver.quit();
		}
	}
}