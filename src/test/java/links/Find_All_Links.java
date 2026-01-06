package links;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_All_Links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumpoint.com/");
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		int linkCount = allLinks.size();
		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			System.out.println(url);
			checkUrl(url);
		}
		System.out.println("Total links in this webpage: "+linkCount);
		driver.close();
	}
	public static void checkUrl(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			connection.setConnectTimeout(2000);
			connection.connect();
			
			if(connection.getResponseCode() >= 400) {
				System.out.println(linkUrl + " is a broken link");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
