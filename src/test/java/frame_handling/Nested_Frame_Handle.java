package frame_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_Frame_Handle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/frames");
		System.out.println("Before click: "+driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		System.out.println("After click:>>>>>> "+driver.getTitle());
		try {
			List <WebElement> all_frames = driver.findElements(By.tagName("iframe"));
			for (WebElement current_frame:all_frames) {
				System.out.println(current_frame.getAttribute("name"));
			}
			driver.switchTo().frame("frame-left");
			System.out.println(driver.findElement(By.name("frame-left")).getText());
			System.out.println(driver.getTitle());
		}
		catch (NoSuchFrameException e)
		{            
			System.out.println(e.getMessage());     
		}
		finally {
			System.out.println("*** END ******");
			driver.close();
		}
	}

}
