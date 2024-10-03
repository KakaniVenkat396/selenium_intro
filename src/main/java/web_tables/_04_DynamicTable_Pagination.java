package web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _04_DynamicTable_Pagination {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		if(!username.getAttribute("value").isEmpty()) {
			username.clear();
		}
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		if(!password.getAttribute("value").isEmpty()) {
			password.clear();
		}
		password.sendKeys("demo");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("//li[@id='menu-customer']//ul//li//a[contains(text(), 'Customers')]")).click();
	
		// Find the number of pages
		String text = driver.findElement(By.xpath("//form[@id='form-customer']//div[contains(text(), 'Showing')]")).getText();
		int numberOfPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		
		// Read the data from each and ever page
		for(int p = 1; p <= 5; p++) {
			if(p > 1) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement active_page = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]")));
			    active_page.click();
			}
			
			//reading data from the page
			
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r=1;r<=noOfRows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
				String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
				
				System.out.println(customerName+"\t"+email+"\t"+status);
			}
		}
	}
}