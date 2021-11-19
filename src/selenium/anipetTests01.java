package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class anipetTests01 {

	static WebDriver driver;
	static String homeTitle = "����� ��� ������ ����� ����";
	static String fName = "����";
	static String lName = "���";
	static String email = "yossiCohen1717@walla.com";
	static String pass = "yossi123";
	static String fNameErr = "��� ���� �� ����";
	static String lNameErr = "��� ���� �� �����";
	static String emailErr = "��� ��� ���� ��������";
	static String passErr = "��� ��� �����; ��� ����� ������ �� ���� ������";
	static String passConfErr = "��� ����� ������ �� ���� ������";
	
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
	
	
	
	
	

}
