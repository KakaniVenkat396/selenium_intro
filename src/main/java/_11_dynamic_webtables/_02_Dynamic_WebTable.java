package _11_dynamic_webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _02_Dynamic_WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int noOfRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		int noOfPages = driver.findElements(By.xpath("//ul[@id='pagination']//li//a")).size();
		for(int p = 1; p <= noOfPages; p++) {
			if(p > 1) {
				WebElement active_page = driver.findElement(By.xpath("//ul[@id='pagination']//li//a[text()='"+p+"']"));
				active_page.click();
				Thread.sleep(2000);
			}
			for(int r = 1; r <= noOfRows; r++) {
				String name = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[2]")).getText();
				String price =driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[3]")).getText();
				driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]/td[4]//input")).click();
				System.out.println(name+"\t"+price);
			}
		}
	}
}