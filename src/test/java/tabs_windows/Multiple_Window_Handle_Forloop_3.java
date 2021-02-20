package tabs_windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Window_Handle_Forloop_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window ID: "+parent_window);
		Set <String> set = driver.getWindowHandles();
		for(String window : set) {
			if(!window.equals(parent_window)) {
				driver.switchTo().window(window);
				System.out.println("Child window ID: "+window + " <== Title > " +driver.getTitle());
				WebElement new_window_element = driver.findElement(By.xpath("//h2[contains(text(),'Enter your email address to get ')]"));
				System.out.println("New window text >>> "+new_window_element.getText());
				driver.close();
			}
		}
		driver.switchTo().window(parent_window);
		System.out.println("Parent window ID: "+parent_window + " <== Title > " +driver.getTitle());
		driver.close();	
	}
}
