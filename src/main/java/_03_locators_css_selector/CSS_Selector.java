package _03_locators_css_selector;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CSS_Selector {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		//tag id      tag#id
		//driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Denver");
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Denver");
		
		//tag class   tag.classname
		//driver.findElement(By.cssSelector("input.nav-input")).sendKeys("Denver");
		//driver.findElement(By.cssSelector(".nav-input")).sendKeys("Denver");
		
		//tag attribute   tag[attribute='value']
		//driver.findElement(By.cssSelector("input[placeholder='Search Amazon.in']")).sendKeys("Denver");
		
		//tag class attribute
		driver.findElement(By.cssSelector("input.nav-input[placeholder='Search Amazon.in']")).sendKeys("Denver");
	}
}