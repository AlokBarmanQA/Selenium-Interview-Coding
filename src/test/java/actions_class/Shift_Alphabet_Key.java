package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Shift_Alphabet_Key {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demoqa.com/auto-complete/");
		WebElement txtbox1 = driver.findElement(By.xpath("//*[@id='autoCompleteMultipleContainer']/div/div[1]"));
		WebElement txtbox2 = driver.findElement(By.xpath("//*[@id='autoCompleteSingleContainer']/div/div[1]"));
		Actions action = new Actions(driver);
		action.keyDown(txtbox1, Keys.SHIFT)
				.sendKeys("green")
				.keyUp(Keys.SHIFT)
				.build()
				.perform();
		action.sendKeys(Keys.ENTER);

		action.keyDown(txtbox2, Keys.SHIFT)
				.sendKeys("green")
				.keyUp(Keys.SHIFT)
				.build()
				.perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER);
	}

}
