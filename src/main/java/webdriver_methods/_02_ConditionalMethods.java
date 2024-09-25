package webdriver_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _02_ConditionalMethods {
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demo.nopcommerce.com/register");
		
		//isDisplayed() -  - we can check display status of the element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		boolean status = logo.isDisplayed();
		System.out.println("The status of logo is: "+status); //true
	
		//isEnabled() - we can check enable/disable status of the element/operational element
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		boolean status2 = searchBox.isEnabled();
		System.out.println("The status of search box is: "+status2); //true
		
		//isSelected - we can use to check the element is selected or not
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //false
		
		male_rd.click();
		System.out.println(male_rd.isSelected()); //true
		System.out.println(female_rd.isSelected()); //false
		
		female_rd.click();
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //true
		
		WebElement chkNewsLetter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
		System.out.println(chkNewsLetter.isSelected()); //true
		
		if(null != driver) {
			driver.quit();
		}
	}
}