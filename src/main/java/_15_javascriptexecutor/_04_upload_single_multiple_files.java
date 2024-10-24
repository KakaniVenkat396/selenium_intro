package _15_javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _04_upload_single_multiple_files {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

		Thread.sleep(2000);
		// SINGLE FILE UPLOAD - TEST1.TXT
		/*
		String file = "C:\\Test1.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file);
		String fileName = driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();
		if(fileName.equals("Test1.txt")) {
			System.out.println("File uploaded successfully.!");
		} else {
			System.out.println("File not uploaded. please check once again");
		}*/
		
		// Multiple files uploaded
		String file1="C:\\Test1.txt";
		String file2="C:\\Test2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		int noOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();

		// VALIDATION 1 - NUMBER OF FILES
		if(noOfFiles == 2) {
			System.out.println("Two files uploaded successfully");
		} else {
			System.out.println("Files uploaded incorrectly.");
		}
		// VALIDATE FILE NAMES
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("Test1.txt")
				&& 
				driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals("Test2.txt")) {
			System.out.println("Files uploaded successfully...!");
		} else {
			System.out.println("Files not uploaded successfully");
		}
	}
}