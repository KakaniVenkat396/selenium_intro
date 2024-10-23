package _13_mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _03_DoubleClickAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		// SWITCH TO FRAME
		driver.switchTo().frame("iframeResult");
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement copyBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		field1.clear(); // CLEARS BOX1
		field1.sendKeys("Hi Akbar");
		
		// DOUBLE CLICK ACTION ON THE BUTTON
		Actions act = new Actions(driver);
		act.doubleClick(copyBtn).build().perform();
		
		// getText() ----> RETURNS INNER TEXT OF THE WEB ELEMENT
		// getAttribute(attribute)--->> RETURNS VALUE OF ATTRIBUTE
		String text1 = field1.getAttribute("value");
		String text2 = field2.getAttribute("value");
		
		// VALIDATION : BOX2 SHOULD CONTAINS "HI AKBAR"
		if(text1.equals(text2)) {
			System.out.println("Content is valid");
		} else {
			System.out.println("Content is invalid");
		}
		
		Thread.sleep(1000);
		if(driver != null) {
			driver.close();
		}
	}
}