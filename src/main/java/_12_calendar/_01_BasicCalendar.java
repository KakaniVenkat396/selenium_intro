package _12_calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

import java.time.Duration;

public class _01_BasicCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://jqueryui.com/datepicker/");

        // SWITCH TO FRAME
        driver.switchTo().frame(0);

        // 1. DIRECTLY SEND THE DATE TO TEXT BOX
        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/19/2024");

        //2. HANDLING THE DATE PICKER
        String exp_day = "30";
        String exp_month = "December";
        String exp_year = "2025";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        while(true) {
            String current_month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String current_year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if(current_month.equals(exp_month) && current_year.equals(exp_year)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Next']//span")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
        for(WebElement date : dates) {
            if(date.getText().equals(exp_day)) {
                date.click();
            }
        }
    }
}
