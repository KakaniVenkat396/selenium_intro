package web_tables;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class _02_Static_Table_Assignment {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		
		driver.get("https://blazedemo.com/");
		
		WebElement depart = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select se = new Select(depart);
		se.selectByVisibleText("Mexico City");
		
		WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select se2 = new Select(destination);
		se2.selectByVisibleText("London");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
	
		// FIND TOTAL NUMBER OF ROWS IN A TABLE
		int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		
		// CREATE AN ARRAY WITH NUMBER OF ROWS
		String[] priceArray = new String[rows];
		
		// ITERATE THE LOOP AND ADD PRICE TO ARRAY
		for(int r = 1; r <= rows; r++) {
			String prices = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();
			priceArray[r-1] = prices;
		}
		
		// PRINT THE PRICES
		for(String price : priceArray) {
			System.out.println(price);
		}
		
		// SORT PRICES THEN FIND LOWER PRICE VALUE
		Arrays.sort(priceArray);
		String lowest_price = priceArray[0];
		
		// FIND RECORD IN TABLE HAVING LOWER PRICE
		for(int r = 1; r <= rows; r++) {
			String prices = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();
			if(prices.equalsIgnoreCase(lowest_price)) {
				driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[1]//input")).click();
				break;
			}
		}
		
		// FILL THE DETAILS THEN CLICK ON PURCHASE FLIGHT BUTTON
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Akbar");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Hitech City");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Telangana");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("521562");
		WebElement cardType = driver.findElement(By.xpath("//select[@name='cardType']"));
		Select se3 = new Select(cardType);
		se3.selectByVisibleText("American Express");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4652 2563 1452 2222");
		WebElement cardMonth = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
		if(!cardMonth.getAttribute("value").isEmpty()) {
			cardMonth.clear();
		}
		cardMonth.sendKeys("7");
		
		WebElement cardYear = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
		if(!cardYear.getAttribute("value").isEmpty()) {
			cardYear.clear();
		}
		cardYear.sendKeys("1995");
		
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Sachin Tendulkar");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		// VALIDATING THE MESSAGE
		String confirmMsg = driver.findElement(By.tagName("h1")).getText();
		
		if(confirmMsg.equalsIgnoreCase("Thank you for your purchase today!")) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case failed");
		}
		
		// CLOSING THE BROWSER
		if(null != driver) {
			driver.quit();
		}
	}
}