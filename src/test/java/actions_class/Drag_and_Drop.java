package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/droppable/");

		WebElement target = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

		Actions actions = new Actions(driver);
		Action seriesOfActions = actions.moveToElement(target)
										.clickAndHold(target)
										.dragAndDrop(target, destination)
										.release(target)
										.build();
						seriesOfActions.perform();
						
		String textTo = destination.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}
		else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
		System.out.println("******** Execution ended *********");
		driver.close();
	}

}
