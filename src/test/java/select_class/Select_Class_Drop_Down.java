package select_class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select_Class_Drop_Down {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
				Thread.sleep(3000);
		WebElement dropdown_box = driver.findElement(By.xpath("//select[@id='testingDropdown']"));
		
		Select select = new Select(dropdown_box);
		
		List <WebElement> elements = select.getOptions();
		for (WebElement element:elements) {
			String element_text = element.getAttribute("text");//href, id, value, class
			System.out.println(element_text);
		}
		
				select.selectByIndex(3);
		Thread.sleep(3000);
				select.selectByValue("Performance");
		Thread.sleep(3000);
				select.selectByVisibleText("Manual Testing");
				
		System.out.println("********** Execution Ended**********");
//		driver.close();
	}

}
