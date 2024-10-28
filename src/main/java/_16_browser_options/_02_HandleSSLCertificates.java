package _16_browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class _02_HandleSSLCertificates {

	public static void main(String[] args) {
		EdgeOptions options = new EdgeOptions();
		// ACCEPTS SSL CERTIFICATES
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com");
		
		System.out.println("The title of the page: "+driver.getTitle());
	}
}