package _15_javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _01_javascript_sendkeys_click {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// CREATE JavascriptExecutor OBJECT
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// PASSING THE TEXT INTO INPUTBOX - ALTERNATE OF sendKeys()
		WebElement txtName = driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value', 'akbar')", txtName);
		
		// CLICKING ON ELEMENT - ALTERNATE OF click()
		WebElement rio_male = driver.findElement(By.xpath("//input[@name='gender' and @value='male']"));
		js.executeScript("arguments[0].click()", rio_male);
	}
}