package web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _03_Static_Table {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		int numOfRows = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr")).size();
		int sum = 0;
		for(int i = 1; i <= numOfRows; i++) {
			sum = sum + Integer.parseInt(driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr["+i+"]//td[4]")).getText());
		}
		//System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		if(sum == total) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		
		if(null != driver) {
			driver.quit();
		}
	}
}