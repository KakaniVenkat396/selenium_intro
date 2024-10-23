package _14_keyboard_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _01_SliderDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Actions act = new Actions(driver);
		
		WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span"));
		WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span/following-sibling::span"));
		
		// MIN SLIDER
		System.out.println("Defualt Location of the min slider : "+min_slider.getLocation()); //(59, 289)
		System.out.println(min_slider.getLocation().getX()); //59
		System.out.println(min_slider.getLocation().getY()); // 289
		
		act.dragAndDropBy(min_slider, 100, 0).build().perform();
		System.out.println("Location of the max slider after moving : "+min_slider.getLocation());
		
		// MAX SLIDER
		System.out.println("Defualt Location of the max slider : "+max_slider.getLocation()); //(542, 251)
		System.out.println(max_slider.getLocation().getX()); //542
		System.out.println(max_slider.getLocation().getY()); //251
		
		act.dragAndDropBy(max_slider, -100, 0).build().perform();
		System.out.println("Location of the max slider after moving :"+max_slider.getLocation());
	}
}