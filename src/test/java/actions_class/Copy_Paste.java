package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Copy_Paste {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Navigate to the demo site
		driver.get("https://demoqa.com/text-box");

		// Enter the Full Name
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Mr.Peter Haynes");

		//Enter the Email
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("PeterHaynes@toolsqa.com");

		// Enter the Current Address
		WebElement currentAddress=driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("43 School Lane London EC71 9GO");
		
		//Create object of the Actions class
		Actions actions = new Actions(driver);
		
	    // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("A");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("C");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        
        //Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("V");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        
		WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));

		System.out.println(currentAddress.getAttribute("value"));
		System.out.println(permanentAddress.getAttribute("value"));
		
//		Assert.assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));
		assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
		
		driver.findElement(By.xpath("//button[@id='submit']")).sendKeys(Keys.ENTER);
		
		driver.close();
	}
}
