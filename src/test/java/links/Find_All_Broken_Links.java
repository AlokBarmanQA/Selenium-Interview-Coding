package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Find_All_Broken_Links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		// https://demoqa.com/broken
		int allURLs = driver.findElements(By.tagName("a")).size();
		System.out.println("Total links in this webpage: "+allURLs);
		List <WebElement> all_URLs = driver.findElements(By.tagName("a"));
		

		for (WebElement URL:all_URLs) {
			String link_URL = URL.getAttribute("href");
			
			HttpURLConnection httpURLConnection;
			try {
				URL url = new URL(link_URL);
				httpURLConnection = (HttpURLConnection)url.openConnection();
				httpURLConnection.setConnectTimeout(2000);
				httpURLConnection.connect();
				
				if (httpURLConnection.getResponseCode() >= 400) {
					System.out.println(link_URL+"-->"+httpURLConnection.getResponseMessage()+"<<<===== is a BROKEN LINK");
				}
				else {
//					System.out.println(link_URL+"-->"+httpURLConnection.getResponseMessage()+"<<<<<<<< is an ACTIVE LINK");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("************ Execution Completed *************");
		driver.close();
	}

}
