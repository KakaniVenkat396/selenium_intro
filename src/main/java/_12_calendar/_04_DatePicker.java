package _12_calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class _04_DatePicker {
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	
		String year = "2025";
		String month = "Dec";
		String day = "31";
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		while(true) {
			// SELECT YEAR
			WebElement yearDrpDwn = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
			Select selectYear = new Select(yearDrpDwn);
			selectYear.selectByValue(year);
		
			// SELECT MONTH
			WebElement monthDrpDwn = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
			Select selectMonth = new Select(monthDrpDwn);
			String currentMonth = selectMonth.getFirstSelectedOption().getText();
			
			if(currentMonth.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement date : dates) {
			if(date.getText().equals(day)) {
				date.click();
				break;
			}
		}
	}
}