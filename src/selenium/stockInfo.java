package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stockInfo {

	static WebDriver driver;
	
	// symbol of the stock you want to search (in CAPITAL LETTERS)
	static String stockSymbol = "TSLA";
	
	static String histQte = "Historical Quotes";
	
	// start & end dates - format of MM/DD/YYYY
	static String startDate = "01/27/2019";
	static String endDate = "01/27/2020";
	
	
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
	
	// stock's options bar
	static public List<WebElement> optionBar(WebDriver driver) {
		List<WebElement> optionBar = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[5]/div/div/li/a"));
		return optionBar;
	}
	
	// stock's historical quotes
	static public WebElement historyQ(WebDriver driver) {
		WebElement historyQ = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[5]/div/div/li[5]/a"));
		return historyQ;
	}
	
	// 'start date' field
	static public WebElement startDateField(WebDriver driver) {
		WebElement startDateField = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[1]/input"));
		return startDateField;
	}
	
	// 'start date' field - 'clear' button
	static public WebElement clearStartBtn(WebDriver driver) {
		WebElement clearStartBtn = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[1]/div/div/div/footer/a[2]"));
		return clearStartBtn;
	}
	
	// 'start date' field - 'close' button
	static public WebElement closeStartBtn(WebDriver driver) {
		WebElement closeStartBtn = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[1]/div/div/div/footer/a[3]"));
		return closeStartBtn;
	}
	
	// 'end date' field
	static public WebElement endDateField(WebDriver driver) {
		WebElement endDateField = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[2]/input"));
		return endDateField;
	}
	
	// 'end date' field - 'clear' button
	static public WebElement clearEndBtn(WebDriver driver) {
		WebElement clearEndBtn = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[2]/div/div/div/footer/a[2]"));
		return clearEndBtn;
	}
	
	// 'end date' field - 'close' button
	static public WebElement closeEndBtn(WebDriver driver) {
		WebElement closeEndBtn = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/div[2]/div[2]/div/div/div/footer/a[3]"));
		return closeEndBtn;
	}
		
	// 'update results' button
	static public WebElement upResBtn(WebDriver driver) {
		WebElement upResBtn = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[6]/div/mw-downloaddata/form/div/button"));
		return upResBtn;
	}
	
	// write to excel file function
	public static void excelPrint(String filePath, String value, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workBook = WorkbookFactory.create(inputStream);
		Sheet sheet = workBook.getSheetAt(0);
		Row r = sheet.getRow(rowNumber);
		if (r == null) {
			r = sheet.createRow(rowNumber);
		}
		org.apache.poi.ss.usermodel.Cell c = r.getCell(cellNumber);
		if (c == null) {
			c = r.createCell(cellNumber);
		}
		c.setCellValue(value);
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workBook.write(outputStream);
		workBook.close();
		outputStream.close();
	}
	
	// stock's page >> historical quotes >> dates
	static public List<WebElement> tableDates(WebDriver driver) {
		List<WebElement> tableDates = driver.findElements(By.xpath("//*[@id=\"download-data-tabs\"]/div/div[1]/table/tbody/child::tr/td[1]/div[1]"));
		return tableDates;
	}
	
	
	
	
	// stock's page >> historical quotes >> next page button
	static public WebElement nextPageBtn(WebDriver driver) {
		WebElement nextPageBtn = driver.findElement(By.xpath("//*[@id=\"download-data-tabs\"]/div/div[2]/a[2]"));
		return nextPageBtn;
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
		Thread.sleep(500);
		for (int i = 0; i < durations(driver).size(); i++) {
			String durX = durations(driver).get(i).getText();
			String yldX = yields(driver).get(i).getText();
			System.out.println(durX + ": " + yldX);
		}
		System.out.println("------------------");
		Thread.sleep(1500);
		
		// go to stock's 'historical quotes'
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {			
			js.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(1500);
			historyQ(driver).click();
			System.out.println("History qoute clicked.");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.err.println("History qoute not clicked.");
		}
				
		// search by range of dates
		js.executeScript("window.scrollBy(0,750)", "");
		try {			
			startDateField(driver).click();
			Thread.sleep(500);
			clearStartBtn(driver).click();
			startDateField(driver).click();
			startDateField(driver).sendKeys(startDate);
			System.out.println("Set startDate.");
		} catch (Exception e) {
			System.err.println("Didn't set startDate.");
		}		
		try {
			endDateField(driver).click();
			Thread.sleep(500);
			clearEndBtn(driver).click();
			endDateField(driver).click();
			endDateField(driver).sendKeys(endDate);
			System.out.println("Set endDate.");
		} catch (Exception e) {
			System.err.println("Didn't set endDate.");
		}		
		upResBtn(driver).click();
		Thread.sleep(3000);
		
		// print the dates out of the historical dates table
		try {
			System.out.println(tableDates(driver).size());
		} catch (Exception e) {
			System.err.println("Couldn't print the dates out of the historical dates table");
		}
		
		
		
		
		
		
		driver.quit();
	}

}
