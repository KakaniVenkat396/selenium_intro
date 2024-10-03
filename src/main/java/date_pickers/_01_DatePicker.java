package date_pickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_DatePicker {
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		
		// Method 1: Using sendKeys method
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/25/2025");
		
		// Method 2: Using date picker
		String month = "June";
		String year = "2026";
		String day = "22";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //actual month
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		for(WebElement date : dates) {
			if(date.getText().equals(day)) {
				date.click();
				break;
			}
		}
	}
}