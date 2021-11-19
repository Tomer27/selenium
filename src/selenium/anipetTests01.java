package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class anipetTests01 {

	static WebDriver driver;
	static String homeTitle = "אניפט רשת חנויות לחיות מחמד";
	static String fName = "יוסי";
	static String lName = "כהן";
	static String email = "yossiCohen1717@walla.com";
	static String pass = "yossi123";
	static String fNameErr = "אנא הכנס שם פרטי";
	static String lNameErr = "אנא הכנס שם משפחה";
	static String emailErr = "אנא הזן דואר אלקטרוני";
	static String passErr = "אנא הזן סיסמא; שדה אימות הסיסמא לא תואם לסיסמא";
	static String passConfErr = "שדה אימות הסיסמא לא תואם לסיסמא";
	static String wrongDitsErr = "הדואר אלקטרוני או הסיסמא שהזנת לא נכונים. אנא נסה שוב";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tomer\\Desktop\\Selenium\\chromeVer95//chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.anipet.co.il/");
		Thread.sleep(500);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	void titleTest() {
		String title = driver.getTitle();
		assertEquals(homeTitle, title);
	}
	
	@Tag("signUp")
	@Test
	void signUpBlankFName() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUEmail(driver).sendKeys(email);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(fNameErr, ErrMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("signUp")
	@Test
	void signUpBlankLName() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SUEmail(driver).sendKeys(email);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(lNameErr, ErrMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("signUp")
	@Test
	void signUpBlankEmail() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(emailErr, ErrMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("signUp")
	@Test
	void signUpBlankPassword() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUEmail(driver).sendKeys(email);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(passErr, ErrMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("signUp")
	@Test
	void signUpBlankConfirmPassword() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUEmail(driver).sendKeys(email);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(passConfErr, ErrMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("signIn")
	@Test
	void signInWrongDetails() throws InterruptedException {
		anipetWE.signInBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SIEmail(driver).sendKeys(email);
		anipetWE.SIPass(driver).sendKeys(pass);
		anipetWE.SIBtn(driver).click();
		Thread.sleep(1000);
		String ErrMsg = anipetWE.SIErrMsg(driver).getText();
		assertEquals(wrongDitsErr, ErrMsg);
		anipetWE.SIXBtn(driver).click();
		Thread.sleep(1000);
	}
	
	@Tag("navBar")
	@Test
	void navBarTest() throws InterruptedException {
		for (int i = 1; i <= anipetWE.mainNavBar(driver).size()-4; i++) {
			String optionName = anipetWE.mainNavBar(driver).get(i).getText();
			anipetWE.mainNavBar(driver).get(i).click();
			Thread.sleep(500);
			if (driver.getTitle().contains(optionName)) {
				System.out.println(optionName + " is OK");
				continue;
			}else {
				System.err.println(optionName + " isn't OK");
				break;
			}
			
		}
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(1000);
	}
	
	
	

}
