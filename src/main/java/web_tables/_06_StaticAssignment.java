package web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _06_StaticAssignment {
	
public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		driver.manage().window().maximize();
		
		int rows=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();
		
		//1) For Chrome process get value of CPU load.
		
		String cpuload=null;
		
		for(int r=1;r<=rows;r++)
		{
			WebElement name=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+r+"]/td[1]"));
			
			if(name.getText().equals("Chrome"))
			{
				cpuload=name.findElement(By.xpath("following-sibling::*[contains(text(),'%')]")).getText();
				break;
			}
	
		}
		
		//2) Compare CPU load with value in the yellow label.
		
		String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();//capture value from yellow label
				
		if(value.contains(cpuload))
		{
			System.out.println("CPU load is equal...");
		}
		else
		{
			System.out.println("CPU load is NOT equal..");
		}
	}
}