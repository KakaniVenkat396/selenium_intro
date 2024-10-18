package _05_webdriver_methods_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _02_ConditionalMethods {
	
	// Conditional methods - access these commands thorugh WebElement

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		// isDisplayed() - we can check display status of the element
		boolean logo_display = driver.findElement(By.xpath("//div[@id='logo']/h1/a")).isDisplayed();
		System.out.println("Logo Display Status: "+logo_display);
		
		// isEnabled() - we can check enable/disable status of the element/operational element
		boolean firstName = driver.findElement(By.xpath("//input[@id='input-firstname']")).isEnabled();
		System.out.println("First Name Filed Status: "+firstName);
		
		// isSelected() - we can use to check the element is selected or not
		WebElement newsletter_yes = driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='1']"));
		WebElement newsletter_no = driver.findElement(By.xpath("//label[@class='radio-inline']//input[@value='0']"));

		System.out.println("Yes radio button selection status: "+newsletter_yes.isSelected());
		System.out.println("No radio button selection status: "+newsletter_no.isSelected());
		
		newsletter_yes.click();
		
		System.out.println("Yes radio button selection status: "+newsletter_yes.isSelected());
		System.out.println("No radio button selection status: "+newsletter_no.isSelected());
	}
}