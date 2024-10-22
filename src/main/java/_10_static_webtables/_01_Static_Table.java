package _10_static_webtables;

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
		
		//1) FIND TOTAL NUMBER OF ROWS IN A TABLE
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // multiple tables
		//int rows = driver.findElements(By.tagName("tr")).size(); // single table
		System.out.println("The number of rows: "+rows);
		
		//2) FIND TOTAL NUMBER OF COLUMNS IN A TABLE
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size(); // multiple tables
		//int cols = driver.findElements(By.tagName("th")).size(); // single table
		System.out.println("The number of cols: "+cols);
		
		//3) READ DATA FROM SPECIFIC ROW AND COLUMN (EX: 5TH ROW AND 1ST COLUMN)
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("Book Name is: "+bookName);
		
		//4) READ DATA FROM ALL THE ROWS AND COLUMNS
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		
		for(int r = 2; r <= rows; r++) {
			for(int c = 1; c <= cols; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		//5) PRINT BOOK NAMES WHOSE AUTHOR IS MUKESH
		for(int r = 2; r <= rows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			if(author.equalsIgnoreCase("mukesh")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(bookname);
			}
		}
		
		//6) FIND TOTAL PRICE OF ALL THE BOOKS
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