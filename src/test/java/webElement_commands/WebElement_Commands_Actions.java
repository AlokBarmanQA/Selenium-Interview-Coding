package webElement_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElement_Commands_Actions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		WebElement textbox = driver.findElement(By.xpath("//input[@id='userName']"));
		// sendKeys command
					textbox.sendKeys("Alok Barman");
		System.out.println(driver.findElement(By.xpath("//input[@id='userName']")).getAttribute("value"));
		// getCssValue command 
		System.out.println("Color>>>"+driver.findElement(By.xpath("//input[@id='userName']")).getCssValue("color"));
		// getSize command
		System.out.println("Size>>>>"+driver.findElement(By.xpath("//input[@id='userName']")).getSize());
		// getLocation command
		System.out.println("Location>>>>"+driver.findElement(By.xpath("//input[@id='userName']")).getLocation());
		// getTagName command
		System.out.println("Tag name>> "+driver.findElement(By.xpath("//input[@id='userName']")).getTagName());
		Thread.sleep(3000);
		// clear command
		textbox.clear();
		System.out.println("Value after clear: "+driver.findElement(By.xpath("//input[@id='userName']")).getAttribute("value"));
		System.out.println("---------------------------------------------------------");
		
		WebElement textboxLink = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
		//isDisplayed command
		boolean flag1 = textboxLink.isDisplayed();
		System.out.println("isDisplayed >>>"+flag1);
		//isEnabled command
		boolean flag2 = textboxLink.isEnabled();
		System.out.println("isEnabled >>>> "+flag2);
		// click command
		WebElement checkboxLink = driver.findElement(By.xpath("//span[contains(text(),'Check Box')]"));
		checkboxLink.click();
		// isSelected command
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
		boolean flag3 = checkbox.isSelected();
		System.out.println(flag3);
		checkbox.click();
		System.out.println("---------------------------------------------------------");	
	}

}
