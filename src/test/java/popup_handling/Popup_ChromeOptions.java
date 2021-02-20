package popup_handling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popup_ChromeOptions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.redbus.in/");
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println("Test completed");
		driver.close();
	}

}
