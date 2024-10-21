package _08_alerts_frames;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1) Normal alert with OK button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		//2) confirmation Alert - OK & Cancel
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		// close alert window using OK button
		//alert2.accept();
		
		// close alert window using Cancel button
		alert2.dismiss();
		
		//3) Prompt alert- Input box
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(1000);
		Alert alert3 = driver.switchTo().alert();
		// Get the information on the alert.
		System.out.println(alert3.getText());
		
		// Send the information in alert text field.
		alert3.sendKeys("akbar");
		// Accept the alert by clicking on Ok button
		alert3.accept();
		
		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(msg.contains("akbar")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}
}