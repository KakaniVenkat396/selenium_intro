package _17_miscllaneous_1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.time.Duration;

public class _01_CaptureScreenshots {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//1) FULL PAGE SCREENSHOT
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		sourceFile.renameTo(targetFile);
		
		//2) CAPTURE THE SCREENSHOT OF SPECIFIC SECTION
		WebElement section = driver.findElement(By.xpath("//div[@id='gw-card-layout']"));
		File source = section.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\section.png");
		source.renameTo(target);
		
		//2) CAPTURE THE SCREENSHOT OF SPECIFIC SECTION
		WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		File src = logo.getScreenshotAs(OutputType.FILE);
		File tar = new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		src.renameTo(tar);
		
		driver.quit();
	}
}