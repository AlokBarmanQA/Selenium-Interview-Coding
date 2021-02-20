package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover_To_Element {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement link_home = driver.findElement(By.linkText("Home"));
		
		WebElement td_home = driver.findElement(By.xpath("//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
		
		Actions actions = new Actions(driver);
		Action mousehover_home = actions.moveToElement(link_home).build();
		String bg_color = td_home.getCssValue("background-color");
		System.out.println("Color before mouse hover: "+bg_color);
		mousehover_home.perform();
		bg_color = td_home.getCssValue("background-color");
		System.out.println("Color after mouse hover: "+bg_color);
		driver.close();
	}

}
