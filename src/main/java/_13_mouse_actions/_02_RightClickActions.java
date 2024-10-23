package _13_mouse_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _02_RightClickActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement edit = driver.findElement(By.xpath("//ul[contains(@class, 'context-menu-root')]//li//span[text()='Edit']"));
		
		Actions act =new Actions(driver);
		
		// RIGHT CLICK ACTION
		act.contextClick(rightClick).build().perform();
		
		// CLICK ON EDIT
		edit.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
		// CLOSE ALERT BOX
		alert.accept();
		
		Thread.sleep(1000);
        driver.close();
    }
}