package tabs_windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_New_Window {

	public static void main(String[] args) {
		// Using Selenium-4
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println("Google title is: "+driver.getTitle());
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String>set = driver.getWindowHandles();
		List<String>windowList = new ArrayList<>(set);
		String parent_window = windowList.get(0);
		String child_window = windowList.get(1);
		System.out.println(parent_window);
		System.out.println(child_window);
		System.out.println("New tab title is: "+driver.getTitle());
		driver.navigate().to("https://www.signal.org/");
		System.out.println("Signal title is: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parent_window);
		System.out.println("Title after close new tab is>>> "+driver.getTitle());
		//org.openqa.selenium.NoSuchWindowException--when lost the driver.
	}

}
