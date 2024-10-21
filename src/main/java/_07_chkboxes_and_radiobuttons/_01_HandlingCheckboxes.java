package _07_chkboxes_and_radiobuttons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_HandlingCheckboxes {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// 1.SELECT SPECIFIC ONE CHECKBOX
		driver.findElement(By.xpath("//input[@id='tuesday']")).click();
		
		// 2.TOTAL NUMBER OF CHECKBOXES
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		//System.out.println("Number of checkboxes: "+checkboxes.size());
		
		
		// 3.SELECT ALL THE CHECKBOXES USING FOR LOOP
		for(int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		} 
		
		// 4.SELECT ALL THE CHECKBOXES USING ENHANCED FOR LOOP
		for(WebElement chkbox : checkboxes) {
			chkbox.click();
		}
		
		// 5.SELECT FIRST THREE CHECKBOXES
		for(int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}
		
		// 6.SELECT LAST THREE CHECKBOXES
		for(int i = 4; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		// 7. SELECT EVEN CHECKBOXES
		for(int i = 0; i < checkboxes.size(); i++) {
			if(i % 2 == 0) {
				checkboxes.get(i).click();
			}
		}
		
		// 8. SELECT ODD NUMBER CHECKBOXES
		for(int i = 0; i < checkboxes.size(); i++) {
			if(i %2 != 0) {
				checkboxes.get(i).click();
			}
		}
		
		// 9. SELECT CHECKBOXES RANDOMLY (1, 3, 6)
		for(int i = 0; i < checkboxes.size(); i++) {
			if(i == 1 || i == 3 || i == 6) {
				checkboxes.get(i).click();
			}
		}
		
		// 9 & 10. SELECT UNSELECTED CHECKBOXES AND UNSELECT CHECKED CHECKBOXES
		for(WebElement chkbox : checkboxes) {
			if(chkbox.isSelected()) {
				chkbox.click();
			} else {
				chkbox.click();
			}
		}
		
		// 11. SELECT THE INDIVIDUAL CHECKBOXES FOR THAT WRITE A SWITCH LOOP
		String weekname = "Friday";
		
		switch(weekname) {
		case "Sunday"    : driver.findElement(By.xpath("//input[@id='sunday']")).click();
						   break;
		case "Monday"    : driver.findElement(By.xpath("//input[@id='monday']")).click();
						   break;
		case "Tuesday"   : driver.findElement(By.xpath("//input[@id='tuesday']")).click();
						   break;
		case "Wednesday" : driver.findElement(By.xpath("//input[@id='wednesday']")).click();
						   break;
		case "Thursday"  : driver.findElement(By.xpath("//input[@id='thursday']")).click();
					  	   break;
		case "Friday"    : driver.findElement(By.xpath("//input[@id='friday']")).click();
						   break;
		case "Saturday"  : driver.findElement(By.xpath("//input[@id='saturday']")).click();
						   break;
		default :          System.out.println("Invalid week day");
		}
	}
}