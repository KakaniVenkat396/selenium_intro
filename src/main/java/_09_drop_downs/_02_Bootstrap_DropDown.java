package _09_drop_downs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _02_Bootstrap_DropDown {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		// OPENS DROP-DOWN OPTIONS
		driver.findElement(By.cssSelector("span[class*='multiselect-selected']")).click();
		
		
		//1) SELECT SINGLE OPTION
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//2) CAPTURE ALL THE OPTIONS AND FIND OUT SIZE
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class*='multiselect-container'] label"));
		System.out.println("The number of options present in drop-down is: "+options.size());
		
		//3) PRINTING OPTIONS FROM DROP-DOWN
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		
		//4) SELECT MULTIPLE OPTIONS
		for(WebElement op : options) {
			String option = op.getText();
			if(option.equalsIgnoreCase("java") || option.equalsIgnoreCase("python")
						|| option.equalsIgnoreCase("mysql")) {
				op.click();
			}
		}
	}
}