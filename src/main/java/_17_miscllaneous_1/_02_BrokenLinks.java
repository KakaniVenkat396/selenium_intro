package _17_miscllaneous_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

/*
 * Conditions:
 * i. link should contains href attribute and value shouldn't empty   href="https://xyz.com"
 * ii. https://xyz.com ---> server ---> status code
 * if(status code>=400) ? broken link : status code <400   not a broken link
 */
public class _02_BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
		int noOfBrokenLinks = 0;
		
		// CAPTURE ALL THE LINKS FROM WEBSITE
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// READ THE EACH AND EVERY LINK AND GET THE ATTRIBUTE OF href
		for(WebElement link : links) {
			String href = link.getAttribute("href");
			
			if(href == null || href.isEmpty()) {
				System.out.println("Either null or an empty url");
				continue;
			}

			// HIT URL TO THE SERVER
			try {
				// CONVERTED href VALUE FROM String TO URL FORMAT
				URL url= new URL(href);
				
				// OPEN CONNECTION TO THE SERVER
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				// CONNECT TO SERVER AND SENT REQUEST THE SERVER
				conn.connect();
				
				if(conn.getResponseCode() >= 400) {
					System.out.println(href+" is a broken link");
					noOfBrokenLinks++;
				} else {
					System.out.println(href+" is not a broken link");
				}
			} catch(Exception e) {
				
			}
		}
		System.out.println("The number of broken links are: "+noOfBrokenLinks);
	}
}