package _04_locators_xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_Xpath {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		//1. Xpath with single attribute
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBoook");
		
		//2. Xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("Tablets");
		
		//3, 4. xpath with 'and'  'or'  operator
		//driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("MacBoook");
		//driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("Tablets");
		
		//5. xpath with text() - inner text
		boolean status = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(status);
		
		String msg = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(msg);
		
		//6. xpath with contains()
		//driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]")).sendKeys("MacBoook");
		
		//7. xpath with start-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("Tablets");
		
		//10. chianed xpath
		boolean logo_status = driver.findElement(By.xpath("//div[@id='logo']/h1/a")).isDisplayed();
		System.out.println(logo_status);
	}
}