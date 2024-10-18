package _06_webdriver_methods_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _03_ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		
		// Explicit wait declaration
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Usage of explicit wait
		WebElement txtUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		txtUserName.sendKeys("Admin");
		
		// Usage of explicit wait
		WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		txtPassword.sendKeys("admin123");
		// Usage of explicit wait
		WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		btnLogin.click();
	}
}