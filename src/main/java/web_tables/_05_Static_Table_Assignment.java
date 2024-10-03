package web_tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _05_Static_Table_Assignment {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		int rows = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr")).size();
		System.out.println("Number of Rows: "+rows);
		int cols = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr[2]//td")).size();
		System.out.println("Number of Rows: "+cols);
		
		List<WebElement> secondRow = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
	}
}