package select_class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_Drop_Down {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//tbody/tr[2]/td[3]/div[1]/span[1]/div[1]/button[1]/b[1]")).click();
		List <WebElement> bootstrap_dropdown = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label"));
		int dropdowncount = bootstrap_dropdown.size();
		System.out.println(dropdowncount);
		for (WebElement element:bootstrap_dropdown) {
			String element_text = element.getText();
			System.out.println(element_text);
			if (element_text.equalsIgnoreCase("Java")) {
				element.click();
				break;
			}
		}
		System.out.println("*********** Execution Ended *************");
	}

}
