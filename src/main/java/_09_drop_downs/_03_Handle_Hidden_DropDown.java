package _09_drop_downs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _03_Handle_Hidden_DropDown {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// LOGIN STEPS
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// CLICKING ON PIM 
		driver.findElement(By.cssSelector("a[href*='viewPimModule']")).click();
		
		// CLICKED ON DROP-DOWN
		driver.findElement(By.xpath("//label[text()='Job Title']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']")).click();
		
		// SELECT SINGLE OPTION
		driver.findElement(By.xpath("//span[text()='Content Specialist']")).click();
		
		// COUNT NUMBER OF OPTIONS
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("The number of options: "+options.size());
		
		// PRINTING OPTIONS
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
	}
}