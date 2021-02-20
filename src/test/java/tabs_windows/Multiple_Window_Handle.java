package tabs_windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Window_Handle {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.naukri.com/");
		System.out.println("Parent window title: "+driver.getTitle());
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.google.com");
//		System.out.println("Google window title: "+driver.getTitle());
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.gmail.com");
//		System.out.println("Gmail window title: "+driver.getTitle());
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window: "+parent_window);
		Set <String> set = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(set);
		
		System.out.println("Main window: "+driver.getTitle());

		driver.switchTo().window(windowList.get(1));
		System.out.println("Second window: "+driver.getTitle());
		driver.switchTo().window(windowList.get(2));
		System.out.println("Third window: "+driver.getTitle());
		driver.switchTo().window(windowList.get(3));
		System.out.println("Fourth window: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(windowList.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());
		driver.close();
//		driver.switchTo().defaultContent();// it does not work.
		driver.switchTo().window(parent_window);
//		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());
		driver.close();
	}
}
