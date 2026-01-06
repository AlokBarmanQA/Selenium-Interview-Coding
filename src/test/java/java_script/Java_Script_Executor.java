package java_script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Script_Executor {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys("Mobiles");
		WebElement goButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
		try {
			Thread.sleep(3000);
			if(goButton.isEnabled() && goButton.isDisplayed()) {
				System.out.println("Clicking element using javascript click");
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", goButton);
			}
			else {
				System.out.println("Unable to click button");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
