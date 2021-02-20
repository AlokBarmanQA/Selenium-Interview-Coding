package links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_All_Links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumpoint.com/");
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println("Total links in this webpage: "+linkCount);
		driver.close();
	}

}
