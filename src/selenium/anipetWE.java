package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class anipetWE {
	
	static WebDriver driver;
	
	// sign up button @ home page
	static public WebElement signUpBtn(WebDriver driver) {
		WebElement signUpBtn = driver.findElement(By.xpath("//*[@id=\"mainapp\"]/div[2]/div[2]/div[1]/div/div[2]/div/ul/li[2]/a"));
		return signUpBtn;
	}
	
	// sign in button @ home page
	static public WebElement signInBtn(WebDriver driver) {
		WebElement signInBtn = driver.findElement(By.xpath("//*[@id=\"mainapp\"]/div[2]/div[2]/div[1]/div/div[2]/div/ul/li[3]/a"));
		return signInBtn;
	}
	
	// navigation bar @ home page
	static public List<WebElement> mainNavBar(WebDriver driver) {
		List<WebElement> mainNavBar = driver.findElements(By.xpath("//*[@id=\"mainapp\"]/div[2]/div[2]/div[2]/div/div/ul/child::li"));
		return mainNavBar;
	}
	
	// navigation bar Strings @ home page
	static public List<WebElement> mainNavBarNames(WebDriver driver) {
		List<WebElement> mainNavBarNames = driver.findElements(By.xpath("//*[@id=\\\"mainapp\\\"]/div[2]/div[2]/div[2]/div/div/ul/li/a/span"));
		return mainNavBarNames;
	}
	
	// first name field @ sign up window
	static public WebElement SUFName(WebDriver driver) {
		WebElement SUFName = driver.findElement(By.id("FirstName"));
		return SUFName;
	}
	
	// last name field @ sign up window
	static public WebElement SULName(WebDriver driver) {
		WebElement SULName = driver.findElement(By.id("LastName"));
		return SULName;
	}
	
	// email field @ sign up window
	static public WebElement SUEmail(WebDriver driver) {
		WebElement SUEmail = driver.findElement(By.id("Email"));
		return SUEmail;
	}
	
	// password field @ sign up window
	static public WebElement SUPass1(WebDriver driver) {
		WebElement SUPass1 = driver.findElement(By.id("Password"));
		return SUPass1;
	}
	
	// confirm password field @ sign up window
	static public WebElement SUPass2(WebDriver driver) {
		WebElement SUPass2 = driver.findElement(By.id("ConfirmPassword"));
		return SUPass2;
	}
	
	// sign up button @ sign up window
	static public WebElement register(WebDriver driver) {
		WebElement register = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/button[1]"));
		return register;
	}
	
	// error message @ sign up window
	static public WebElement SUErrMsg(WebDriver driver) {
		WebElement SUErrMsg = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]"));
		return SUErrMsg;
	}
	
	// X button @ sign up window
	static public WebElement SUXBtn(WebDriver driver) {
		WebElement SUXBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/button"));
		return SUXBtn;
	}
	
	// email field @ sign in window
	static public WebElement SIEmail(WebDriver driver) {
		WebElement SIEmail = driver.findElement(By.id("Email"));
		return SIEmail;
	}
	
	// password field @ sign in window
	static public WebElement SIPass(WebDriver driver) {
		WebElement SIPass = driver.findElement(By.id("Password"));
		return SIPass;
	}
	
	// sign in button @ sign in window
	static public WebElement SIBtn(WebDriver driver) {
		WebElement SIBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/button[1]"));
		return SIBtn;
	}
	
	// error message @ sign in window
	static public WebElement SIErrMsg(WebDriver driver) {
		WebElement SIErrMsg = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div[1]"));
		return SIErrMsg;
	}
	
	// X button @ sign in window
	static public WebElement SIXBtn(WebDriver driver) {
		WebElement SIXBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/button"));
		return SIXBtn;
	}
	
	
	
	
	

}
