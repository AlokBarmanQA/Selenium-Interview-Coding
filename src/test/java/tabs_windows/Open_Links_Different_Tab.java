package tabs_windows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Links_Different_Tab {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement linkTab = driver.findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility'][1]"));
		List <WebElement> linkList = linkTab.findElements(By.tagName("a"));
		int length = linkList.size();
		System.out.println(length);
		for(int i=0; i<length; i++) {
			String openTabsAgain = Keys.chord(Keys.CONTROL, Keys.ENTER);
			linkList.get(i).sendKeys(openTabsAgain);
		}
	}

}
