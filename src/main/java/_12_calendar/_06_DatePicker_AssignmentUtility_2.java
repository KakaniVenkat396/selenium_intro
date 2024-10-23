package _12_calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_DatePicker_AssignmentUtility_2 {
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	
		String year = "2023";
		String month = "Jul";
		String day = "31";
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		// selectFutureDate(driver, year, month, day);
		selectPastDate(driver, year, month, day);
	}
	
	public static void selectFutureDate(WebDriver driver, String year, String month, String day) {
		while(true) {
			WebElement yearDrpDwn = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
			Select selectYear = new Select(yearDrpDwn);
			selectYear.selectByValue(year);
		
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
	
	public static void selectPastDate(WebDriver driver, String year, String month, String day) {
		while(true) {
			WebElement yearDrpDwn = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
			Select selectYear = new Select(yearDrpDwn);
			selectYear.selectByValue(year);
		
			WebElement monthDrpDwn = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
			Select selectMonth = new Select(monthDrpDwn);
			String currentMonth = selectMonth.getFirstSelectedOption().getText();
			
			if(currentMonth.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement date : dates) {
			if(date.getText().equals(day)) {
				date.click();
				break;
			}
		}
	}
	
	public static Month convertStringToMonthObject(String month) {
		
		Map<String, Month> monthMap = new HashMap<>();
		monthMap.put("Jan", Month.JANUARY);
		monthMap.put("Feb", Month.FEBRUARY);
		monthMap.put("Mar", Month.MARCH);
		monthMap.put("Apr", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("Jun", Month.JUNE);
		monthMap.put("Jul", Month.JULY);
		monthMap.put("Aug", Month.AUGUST);
		monthMap.put("Sep", Month.SEPTEMBER);
		monthMap.put("Oct", Month.OCTOBER);
		monthMap.put("Nov", Month.NOVEMBER);
		monthMap.put("Dec", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		
		if(vmonth == null) {
			System.out.println("Invalid Month..!");
		}
		return vmonth;
	}
}