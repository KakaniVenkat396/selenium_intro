package _11_dynamic_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _03_Dynamic_WebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login Steps
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Click on Admin from left panel
        driver.findElement(By.cssSelector("a[href*='AdminModule']")).click();
        Thread.sleep(2000);

        // Number of rows present in the table
        int noOfRows = driver.findElements(By.xpath("//div[@role='table']//div[@class='oxd-table-body']//div[@class='oxd-table-card']//div[@role='row']")).size();

        // Iterate the each and every row and get the values
        for(int r = 1; r <= noOfRows; r++){
            String username = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[2]")).getText();
            String userrole = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[3]")).getText();
            String empname = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[4]")).getText();
            String status = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div//div[5]")).getText();
            System.out.println(username+"\t"+userrole+"\t"+empname+"\t"+status);
        }
    }
}