package _12_calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class _02_BasicCalendar_Utility {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://jqueryui.com/datepicker/");

        // SWITCH TO FRAME
        driver.switchTo().frame(0);

        // 1. METHOD1 : USING SENDKEYS()
        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/19/2024");

        //2. METHOD2 : USING DATE PICKER
        // CLICKING ON TEXT BOX TO OPEN THE DATE PICKER
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        //selectFutureDate(driver, "25", "December", "2025");
        selectPastDate(driver, "25", "December", "2022");
    }

    // SELECTING FUTURE DATE
    public static void selectFutureDate(WebDriver driver, String exp_day, String exp_month, String exp_year) {
        while (true) {
            // ACTUAL MONTH
            String current_month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            // ACTUAL YEAR
            String current_year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (current_month.equals(exp_month) && current_year.equals(exp_year)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Next']//span")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
        for (WebElement date : dates) {
            if (date.getText().equals(exp_day)) {
                date.click();
                break;
            }
        }
    }

    // SELECTING PAST DATE
    public static void selectPastDate(WebDriver driver, String exp_day, String exp_month, String exp_year) {
        while (true) {
            // ACTUAL MONTH
            String current_month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            // ACTUAL YEAR
            String current_year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (current_month.equals(exp_month) && current_year.equals(exp_year)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Prev']//span")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
        for (WebElement date : dates) {
            if (date.getText().equals(exp_day)) {
                date.click();
                break;
            }
        }
    }
}
