package _16_browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class _04_RunTestsIncognitoMode {
	public static void main(String[] args) {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();
		if(title.contains("Online Shopping site in India: ")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test Failed");
		}
	}
}