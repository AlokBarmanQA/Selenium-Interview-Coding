package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Series_Of_Actions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		String baseUrl = "http://www.facebook.com/"; 
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions actions = new Actions(driver);
		Action seriesOfActions = actions.moveToElement(txtUsername)
										.click()
										.keyDown(txtUsername, Keys.SHIFT)
										.sendKeys(txtUsername, "hello")
										.keyUp(txtUsername, Keys.SHIFT)
										.doubleClick(txtUsername)
										.contextClick()
										.build();
			
						seriesOfActions.perform() ;
		System.out.println("****** END ********");
		driver.close();
	}

}
