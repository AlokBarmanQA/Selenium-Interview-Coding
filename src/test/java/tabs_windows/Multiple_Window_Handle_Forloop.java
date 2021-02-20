package tabs_windows;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Window_Handle_Forloop {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.naukri.com/");

		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window: "+parent_window);
		Set <String> set = driver.getWindowHandles();
		for(String window : set) {
			driver.switchTo().window(window);
			System.out.println(window + " <==> " +driver.getTitle());
			driver.close();
		}
	}
}
