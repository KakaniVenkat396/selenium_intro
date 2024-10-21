package _09_drop_downs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class _01_Static_DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select selCountry = new Select(country);
		
		// SELECT OPTION BY VISIBLE TEXT
		selCountry.selectByVisibleText("Brazil");
		Thread.sleep(1000);
		
		// SELECT OPTION BY VALUE
		selCountry.selectByValue("germany");
		Thread.sleep(1000);
		
		// SELECT OPTION BY INDEX
		selCountry.selectByIndex(5);
		Thread.sleep(1000);
		
		// COUNT THE NUMBER OF COUNTRIES IN THE DROP-DOWN
		List<WebElement> country_list = selCountry.getOptions();
		int noOfCountries = country_list.size();
		System.out.println("List of countries: "+noOfCountries);
		
		// PRINT THE OPTIONS USING FOR LOOP
		for(int i = 0; i < country_list.size(); i++) {
			System.out.println(country_list.get(i).getText());
		}
		
		System.out.println();
		
		// PRINT THE OPTIONS USING ENHANCED FOR LOOP
		for(WebElement option : country_list) {
			System.out.println(option.getText());
		}
	}
}