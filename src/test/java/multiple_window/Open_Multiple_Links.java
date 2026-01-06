package multiple_window;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Multiple_Links {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement makeMoneyWithUsPannel = driver.findElement(By.xpath("//*[@id='navFooter']/div[1]/div/div[3]/ul"));
		
		List <WebElement> links = makeMoneyWithUsPannel.findElements(By.tagName("a"));
		for(WebElement link : links) {
			String keyActions = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.sendKeys(keyActions);
		}

	}

}
