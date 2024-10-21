package _05_webdriver_methods_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _03_NavigationalMethods {
	
	/*
	 * driver.get()  ---> accepts URL in string format only
	 * driver.navigate().to() ---> accepts URL in the string format & URL object format.
	 */

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Launch the e commerce application
		// Accepts URL only in the string format
		driver.get("https://tutorialsninja.com/demo/");
		System.out.println(driver.getTitle());
		
		// Navigate to orange hrm application
		// URL myurl=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.navigate().to(myurl);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		
		// Navigate back to e commerce application
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		// Again goes to orange hrm application
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.close();
	}
}