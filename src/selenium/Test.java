package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	static WebDriver driver;
	static WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));	
	static List<WebElement> results = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul/child::li"));
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tomer\\Desktop\\Selenium\\chromeVer95//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/webhp");				
		searchField.sendKeys("what is a test");
		Thread.sleep(500);		
		for (int i = 0; i < results.size(); i++) {
			String x = results.get(i).getText();
			if (x.contains("what is a test")) {
				results.get(i).click();
				break;
			}
		}
		Thread.sleep(1500);
		String desc = driver.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div/div/div/div/div/div/div/div/div/span[1]")).getText();
		System.out.println(desc);
		
		
		
		driver.quit();
		

	}

}
