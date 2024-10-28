package _16_browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class _05_EnableExtensionsAtRuneTime {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Automation\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		options.addExtensions(file);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
	}
}