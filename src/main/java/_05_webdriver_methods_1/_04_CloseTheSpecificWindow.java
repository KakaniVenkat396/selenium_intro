package _05_webdriver_methods_1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _04_CloseTheSpecificWindow {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Launch the e commerce application
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		Set<String> windowids = driver.getWindowHandles();
		
		for(String windowId : windowids) {
			String title = driver.switchTo().window(windowId).getTitle();
		
			if(title.equals("OrangeHRM") || title.equals("title-1") || title.equals("title-2")) {
				driver.close();
			}
		}
	}
}