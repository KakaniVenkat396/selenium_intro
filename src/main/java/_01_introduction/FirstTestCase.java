package _01_introduction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver(); // 1. FOR EDGE BROWSER
		
		//WebDriver driver = new ChromeDriver(); // FOR CHROME BROWSER
		
		// WebDriver driver = new FirefoxDriver(); // FOR FIREFOX BROWSER
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// 2) OPEN URL https://testautomationpractice.blogspot.com/
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//3) VALIDATE THE TITLE
		String exp_title = "Automation Testing Practice";
		String act_title = driver.getTitle(); 
		
		if(exp_title.equals(act_title)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		// 4) close browser
		// driver.close();
		driver.quit();
	}
}