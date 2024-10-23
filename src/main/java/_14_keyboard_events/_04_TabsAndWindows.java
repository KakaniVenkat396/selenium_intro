package _14_keyboard_events;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _04_TabsAndWindows {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Selenium4.x
		// OPENS NEW TAB
		driver.switchTo().newWindow(WindowType.TAB);

		// OPENS NEW WINDOW
		// driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.co.in/");
	}
}