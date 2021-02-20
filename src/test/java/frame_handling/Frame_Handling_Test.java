package frame_handling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_Handling_Test {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/guru99home/");

		//Get the size/ total number of frames in a web page
		int framesize = driver.findElements(By.tagName("iframe")).size();
		System.out.println(framesize);
		List <WebElement> allframes = driver.findElements(By.tagName("iframe"));
		for (WebElement frame:allframes) {
			System.out.println(frame.getAttribute("id"));
		}
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//*[@id='movie_player']/div[3]/div[2]/div/a")).getText());
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//iframe[1]")).click();
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("/html/body/a/img")).click();
		String parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(! window.equals(parent_window)) {
				driver.switchTo().window(window);
			}
		}
		String secondPage = driver.findElement(By.xpath
				("//h1[contains(text(),'Selenium Live Project: FREE Real Time Project for ')]")).getText();
		System.out.println("Second window text: "+secondPage);
		driver.close();
		driver.switchTo().window(parent_window);
		driver.close();
	}

}
