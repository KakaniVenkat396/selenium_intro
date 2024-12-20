package _13_mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


// Actions -- class, will be used to perform mouse actions,
// Action --- interface, will be used to store created actions.

public class _05_ActionsVsAction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act=new Actions(driver);

		// BUILDING/CREATING AN ACTION AND STORING INTO A VARIABLE
		Action myaction=act.contextClick(button).build();

		// WE ARE PERFORMING/COMPLETING ACTION
		myaction.perform();
	}
}