package _07_chkboxes_and_radiobuttons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _02_HandlingRadiobuttons {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://practice.expandtesting.com/radio-buttons");
		
		// 1.SELECT SPECIFIC RADIO BUTTON
		//driver.findElement(By.xpath("//input[@id='yellow']")).click();

		// 2.TOTAL NUMBER OF RADIO BUTTONS
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[contains(@class, 'card-custom')]//input[@type='radio']"));
		System.out.println(radiobuttons.size());
		
		String color="Green";
		switch(color) {
		case "Blue"   : driver.findElement(By.xpath("//input[@id='blue']")).click();
						break;
		case "Red"    : driver.findElement(By.xpath("//input[@id='red']")).click();
						break;
		case "Yellow" : driver.findElement(By.xpath("//input[@id='yellow']")).click();
		                break;
		case "Black"  : driver.findElement(By.xpath("//input[@id='black']")).click();
						break;
		case "Green"  : driver.findElement(By.xpath("//input[@id='green']")).click();
						break;
		default       : System.out.println("Invalid color");
		}
	}
}