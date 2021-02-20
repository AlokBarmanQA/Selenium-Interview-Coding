package webElement_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Submit_Form {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		By firstname = By.xpath("//input[@id='firstName']");
		By lastname = By.xpath("//input[@id='lastName']");
		By email = By.xpath("//input[@id='userEmail']");
		By gender = By.xpath("//label[contains(text(),'Male')]");
		By mobileNumber = By.xpath("//input[@id='userNumber']");
//		By dateofbirth = By.xpath("//input[@id='dateOfBirthInput']");
//		By subject = By.xpath("//*[@id='subjectsContainer']/div/div[1]");
		By hobbies_reading = By.xpath("//label[contains(text(),'Reading')]");
//		By picture_choose_file = By.xpath("//input[@id='uploadPicture']");
		By current_address = By.xpath("//textarea[@id='currentAddress']");
		By state = By.xpath("//*[@id='state']/div/div[2]/div");
		By city = By.xpath("//*[@id='city']/div/div[2]/div");
		By submit = By.xpath("//button[@id='submit']");
		
		driver.findElement(firstname).sendKeys("Alok");
		driver.findElement(lastname).sendKeys("Barman");
		driver.findElement(email).sendKeys("abc@xyz.com");
		driver.findElement(gender).click();
		driver.findElement(mobileNumber).sendKeys("9876543210");
//		driver.findElement(dateofbirth).clear();
//		driver.findElement(dateofbirth).sendKeys("11 Feb 1971");
//		driver.findElement(subject).sendKeys("Chemistry");
		driver.findElement(hobbies_reading).click();
		driver.findElement(current_address).sendKeys("Maynaguri Rd");
		driver.findElement(state).sendKeys("Rajasthan");
		driver.findElement(city).sendKeys("Jaipur");
		driver.findElement(submit).submit();
		
		System.out.println("******* End ********");
	}

}
