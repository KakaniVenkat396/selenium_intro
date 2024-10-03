package web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _07_DynamicTable_Assignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int noOfRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		//System.out.println("Number of Rows: "+noOfRows);
		
		int noOfCols = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr[1]//td")).size();
		//System.out.println("Number of Cols: "+noOfCols);
		
		int noOfPages = driver.findElements(By.xpath("//ul[@id='pagination']//li//a")).size();
		for(int p = 1; p <= noOfPages; p++) {
			if(p > 1) {
				driver.findElement(By.xpath("//ul[@id='pagination']//li//a[text()="+p+"]")).click();
				Thread.sleep(1000);
			}
			
			for(int r = 1; r <= noOfRows; r++) {
				for(int c = 1; c < noOfCols; c++) {
					String data = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td["+c+"]")).getText();
					driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input")).click();
					System.out.print(data+"\t");
				}
				System.out.println();
			}
		}
		
		if(null != driver) {
			driver.quit();
		}
	}
}