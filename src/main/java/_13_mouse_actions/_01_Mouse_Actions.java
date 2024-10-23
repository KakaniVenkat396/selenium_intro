package _13_mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/*
 * Actions - pre defined class provided in selenium
 * build() - create an action
 * perform() - complete an action
 */

public class _01_Mouse_Actions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		WebElement signIn = driver.findElement(By.xpath("//div[@id='nav-tools']//a[contains(@href, 'signin')]"));
		WebElement orders = driver.findElement(By.xpath("//a[@id='nav_prefetch_yourorders']/span"));
		
		Actions act = new Actions(driver);
		
		// MOUSE HOVER
		act.moveToElement(signIn).moveToElement(orders).click().build().perform();
		
		Thread.sleep(1000);
		if(driver != null) {
			driver.close();
		}
	}
}