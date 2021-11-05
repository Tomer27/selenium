package selenium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stockInfo {

	static WebDriver driver;
	
	// symbol of the stock you want to search (in CAPITAL LETTERS)
	static String stockSymbol = "AMZN";
	
	// 'search' button in the main page
	static public WebElement mainSearchBtn(WebDriver driver) {
		WebElement mainSearchBtn = driver.findElement(By.xpath("/html/body/section[1]/nav/header/button"));
		return mainSearchBtn;
	}
	
	// 'search' field
	static public WebElement searchField(WebDriver driver) {
		WebElement searchField = driver.findElement(By.id("search"));
		return searchField;
	}
	
	// results list
	static public List<WebElement> results(WebDriver driver) {
		List<WebElement> results = driver.findElements(By.xpath("/html/body/div[9]/div/div[2]/div[1]/div/child::a"));
		return results;
	}
	
	// results list >> symbols text
	static public List<WebElement> symbols(WebDriver driver) {
		List<WebElement> symbols = driver.findElements(By.xpath("/html/body/div[9]/div/div[2]/div[1]/div/child::a/div/h4/span"));
		return symbols;
	}
	
	// stock name
	static public WebElement stockName(WebDriver driver) {
		WebElement stockName = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div[2]/h1"));
		return stockName;
	}
	
	// durations list
	static public List<WebElement> durations(WebDriver driver) {
		List<WebElement> durations = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[6]/div[1]/div[2]/div/table/tbody/child::tr/td[1]"));
		return durations;
	}
	
	// yields list
	static public List<WebElement> yields(WebDriver driver) {
		List<WebElement> yields = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[6]/div[1]/div[2]/div/table/tbody/child::tr/td[2]/ul/li[1]"));
		return yields;
	}
	
	// current stock price
	static public WebElement currentPrice(WebDriver driver) {
		WebElement currentPrice = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[3]/div/div[2]/h2/bg-quote"));
		return currentPrice;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// enter path to 'chromedriver.exe' on your PC
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tomer\\Desktop\\Selenium\\chromeVer95//chromedriver.exe"); 
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marketwatch.com/");
		
		// click on the 'search' button in the main page and wait 0.5 sec
		mainSearchBtn(driver).click();
		Thread.sleep(500);
		
		// enter the symbol in the 'search' field and click on the correct option from results
		searchField(driver).sendKeys(stockSymbol);
		Thread.sleep(3000);
		for (int i = 0; i < results(driver).size(); i++) {
			String symbolX = symbols(driver).get(i).getText();
			if (symbolX.equals(stockSymbol)) {
				results(driver).get(i).click();
				break;
			}else {
				continue;
			}
		}
		
		// print to console: current date and time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		
		// print to console: current price
		System.out.println(stockName(driver).getText() + " current price is " + currentPrice(driver).getText() + "$");
		
		// print to console: yields by durations
		System.out.println("It's yields are:");
		Thread.sleep(1500);
		for (int i = 0; i < durations(driver).size(); i++) {
			String durX = durations(driver).get(i).getText();
			String yldX = yields(driver).get(i).getText();
			System.out.println(durX + ": " + yldX);
		}	
		
		driver.quit();
	}

}
