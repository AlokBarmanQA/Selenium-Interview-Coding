package switch_To_Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToNestedFrames {

	public static void main(String[] args) {
		WebDriver driver;
		String url = "http://demo.guru99.com/test/guru99home/";
		WebDriverManager.iedriver().setup();
//		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); 
//		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, ""); 		
		driver=new InternetExplorerDriver();
		driver.get(url);
		driver.manage().window().maximize();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames --" + size);

		// prints the total number of frames 
		driver.switchTo().frame(0); // Switching the Outer Frame    		
		System.out.println (driver.findElement(By.xpath("xpath of the outer element ")).getText());

		//Printing the text in outer frame
		size = driver.findElements(By.tagName("iframe")).size();
		// prints the total number of frames inside outer frame           

		System.out.println("Total Frames --" + size);
		driver.switchTo().frame(0); // Switching to innerframe
		System.out.println(driver.findElement(By.xpath("xpath of the inner element ")).getText());

		//Printing the text in inner frame
		driver.switchTo().defaultContent();	}

}
