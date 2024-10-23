package _14_keyboard_events;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _03_OpentheLinkInNewTab {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement material = driver.findElement(By.cssSelector("a[class='blinkingText']"));
		
		Actions act = new Actions(driver);

		// CONTROL+LINK
		act.keyDown(Keys.CONTROL).click(material).keyUp(Keys.CONTROL).build().perform();

		// SWITCHING TO REGISTRATION PAGE
		List<String> windIds = new ArrayList<>(driver.getWindowHandles());

		// SWITCH TO MATERIALS PAGE
		driver.switchTo().window(windIds.get(1));
		
		String message = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();

		// HOME PAGE
		driver.switchTo().window(windIds.get(0));
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(message);
	}
}
