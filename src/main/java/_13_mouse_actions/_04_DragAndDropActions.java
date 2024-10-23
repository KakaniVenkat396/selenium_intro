package _13_mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _04_DragAndDropActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		// DRAG AND DROP1
		WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
		WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));

		// DRAG AND DROP2
		WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
		WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
		WebElement southkorea = driver.findElement(By.xpath("//div[@id='box105']"));
		WebElement unitedstates = driver.findElement(By.xpath("//div[@id='box103']"));
		WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
		WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
		WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(rome, italy).build().perform();
		act.dragAndDrop(washington, unitedstates).build().perform();
		act.dragAndDrop(oslo, norway).build().perform();
		act.dragAndDrop(seoul, southkorea).build().perform();
		act.dragAndDrop(stockholm, sweden).build().perform();
		act.dragAndDrop(madrid, spain).build().perform();
		act.dragAndDrop(copenhagen, denmark).build().perform();
		
		Thread.sleep(1000);
        driver.close();
    }
}