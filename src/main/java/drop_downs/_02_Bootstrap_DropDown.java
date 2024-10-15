package drop_downs;

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
		
		
		//1) Select single option
		driver.findElement(By.cssSelector("span[class*='multiselect-selected']")).click();
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//2) capture all the options and find out size
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class*='multiselect-container'] label"));
		System.out.println("The number of options present in drop-down is: "+options.size());
		
		//3) printing options from drop-down
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		
		//4) select multiple options
		for(WebElement op : options) {
			String option = op.getText();
			if(option.equalsIgnoreCase("java") || option.equalsIgnoreCase("python")
						|| option.equalsIgnoreCase("mysql")) {
				op.click();
			}
		}
	}
}