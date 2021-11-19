package selenium;

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
	
	
	
	

}
