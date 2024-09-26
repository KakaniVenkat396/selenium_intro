package web_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01_Static_Table {
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1) find total number of rows in a table
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // multiple tables
		//int rows = driver.findElements(By.tagName("tr")).size(); // single table
		System.out.println("The number of rows: "+rows);
		
		//2) find total number of columns in a table
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size(); // multiple tables
		//int cols = driver.findElements(By.tagName("th")).size(); // single table
		System.out.println("The number of cols: "+cols);
		
		//3) Read data from specific row and column (ex: 5th row and 1st column)
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("Book Name is: "+bookName);
		
		//4) read data from all the rows and columns
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		
		for(int r = 2; r <= rows; r++) {
			for(int c = 1; c <= cols; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		//5) Print book names whose author is Mukesh
		for(int r = 2; r <= rows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			if(author.equalsIgnoreCase("mukesh")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(bookname);
			}
		}
		
		//6) Find total price of all the books
		int total = 0;
		for(int r = 2; r <= rows; r++) {
			String price= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			total = total + Integer.parseInt(price);
		}
		System.out.println("The total price is: "+total);
		
		if(null != driver) {
			driver.quit();
		}
	}

}
