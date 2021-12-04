package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class anipetTests01 {

	static WebDriver driver;
	static String homeTitle = "אניפט רשת חנויות לחיות מחמד";
	static String fName = "יוסי";
	static String lName = "כהן";
	static String fullName = "וסי כהן";
	static String email = "yossiCohen1717@walla.com";
	static String email2 = "yossillll2122@mailinator.com"; // needs to be changed each run to a new address
	static String pass = "yossi123";
	static String phoneNum = "0581111111";
	static String messageContent = "aaaaaaaaaaaaa";
	static String fNameErr = "אנא הכנס שם פרטי";
	static String lNameErr = "אנא הכנס שם משפחה";
	static String fullNameErr = "אנא הזן שם";
	static String emailErr = "אנא הזן דואר אלקטרוני";
	static String passErr = "אנא הזן סיסמא; שדה אימות הסיסמא לא תואם לסיסמא";
	static String passConfErr = "שדה אימות הסיסמא לא תואם לסיסמא";
	static String wrongDitsErr = "הדואר אלקטרוני או הסיסמא שהזנת לא נכונים. אנא נסה שוב";
	static String phoneNumErr = "אנא הזן מס' טלפון";
	static String persArea = "אזור אישי";
	static String logOut = "התנתק";
	static String exstUser = "User name '" + email2 + "' is already taken."; // email needs to be changed according to 'email2'
	static String srchObject = "קולר";
	static String nextPageSign = "»";
	static String contact = "צור קשר";
	static String totalBuy = "150";
	static String shipCost = "חינם";
	
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
	
	@Tag("signUp")
	@Test
	void successfullSignUp() throws InterruptedException {
		String a = anipetWE.signUpBtn(driver).getText();
		String b = anipetWE.signInBtn(driver).getText();
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUEmail(driver).sendKeys(email2);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1500);
		String c = anipetWE.signUpBtn(driver).getText();
		String d = anipetWE.signInBtn(driver).getText();
		System.out.println("Before: " + a + "; " + b);
		System.out.println("After: " + c + "; " + d);
		anipetWE.signInBtn(driver).click();
		Thread.sleep(500);
	}
	
	@Tag("signUp")
	@Test
	void successfullSignUp2() throws InterruptedException {
		anipetWE.signUpBtn(driver).click();
		Thread.sleep(2000);
		anipetWE.SUFName(driver).sendKeys(fName);
		anipetWE.SULName(driver).sendKeys(lName);
		anipetWE.SUEmail(driver).sendKeys(email2);
		anipetWE.SUPass1(driver).sendKeys(pass);
		anipetWE.SUPass2(driver).sendKeys(pass);
		anipetWE.register(driver).click();
		Thread.sleep(1500);
		String errMsg = anipetWE.SUErrMsg(driver).getText();
		assertEquals(exstUser, errMsg);
		anipetWE.SUXBtn(driver).click();
		Thread.sleep(500);
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
	
	@Tag("navBar")
	@Test
	void subCategoriesTest() throws InterruptedException {
		for (int i = 2; i < anipetWE.mainNavBar(driver).size()-3; i++) {
			anipetWE.mainNavBar(driver).get(i).click();
			for (int j = 0; j < anipetWE.subCtgry(driver).size(); j++) {
				String subX = anipetWE.subCtgry(driver).get(j).getText();
				anipetWE.subCtgry(driver).get(j).click();
				Thread.sleep(500);
				String subC = anipetWE.subCName(driver).getText();
				if (subX.equals(subC)) {
					anipetWE.mainNavBar(driver).get(i).click();
				}else {
					System.out.println(subX + " in " + anipetWE.mainNavBar(driver).get(i).getText() + " isn't OK.");
					anipetWE.mainNavBar(driver).get(i).click();
				}
			}
		}
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(1000);
	}
	
	@Tag("search")
	@Test
	void searchResultsValidation() throws InterruptedException {
		anipetWE.srchFld(driver).sendKeys(srchObject);
		anipetWE.srchBtn(driver).click();
		Thread.sleep(500);
		for (int j = 0; j < anipetWE.resPages(driver).size()-1; j++) {
			for (int i = 0; i < anipetWE.results(driver).size(); i++) {
				String resX = anipetWE.results(driver).get(i).getText();
				if (resX.contains(srchObject)) {
					continue;
				}else {
					System.out.println(resX + " isn't relevant to the search");
					break;
				}
			}
			try {
				for (int q = 0; q < anipetWE.resPages(driver).size(); q++) {
					String pageX = anipetWE.resPages(driver).get(q).getText();
					if (pageX.equals(nextPageSign)) {
						anipetWE.resPages(driver).get(q).click();
					}else {
						continue;
					}
				}
			} catch (Exception e) {
				
			}			
		}
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);		
	}
	
	@Tag("payment")
	@Test
	void finalPaymentTest() throws InterruptedException {
		anipetWE.mainNavBar(driver).get(1).click();
		Thread.sleep(100);
		anipetWE.dogDisc(driver).click();
		Thread.sleep(100);
		int sumBuy = 0;
		for (int i = 0; i < 3; i++) {
			String priceStr = anipetWE.itemsListPrices(driver).get(i).getText().replace("₪", "");
			int price = Integer.parseInt(priceStr);
			sumBuy += price;
		}
		System.out.println("Expected sum of the first 3 items: " + sumBuy + "₪");
		for (int i = 0; i < 3; i++) {
			anipetWE.add2CartBtns(driver).get(i).click();
			Thread.sleep(1000);
			anipetWE.cartXBtn(driver).click();
			Thread.sleep(1000);
		}
		anipetWE.mainNavBar(driver).get(8).click();
		Thread.sleep(1000);
		String totalPayStr = anipetWE.totalPayment(driver).getText().replace("₪", "").replace(".00", "");
		int totalPay = Integer.parseInt(totalPayStr);
		System.out.println("Actual sum of the first 3 items: " + totalPay + "₪");
		anipetWE.mainNavBar(driver).get(0).click();
		assertEquals(sumBuy, totalPay);
		Thread.sleep(500);
	}
	
	@Tag("contactUs")
	@Test
	void contactUsBlankName() throws InterruptedException {
		for (int i = 0; i < anipetWE.infoOptions(driver).size(); i++) {
			String optionX = anipetWE.infoOptions(driver).get(i).getText();
			if (optionX.equals(contact)) {
				anipetWE.infoOptions(driver).get(i).click();
			}else {
				continue;
			}
		}
		Thread.sleep(1000);
		anipetWE.CUEmail(driver).sendKeys(email2);
		anipetWE.CUPhone(driver).sendKeys(phoneNum);
		anipetWE.CUMessage(driver).sendKeys(messageContent);
		anipetWE.CUSendBtn(driver).click();
		Thread.sleep(1500);
		String errorMessage = anipetWE.CUErrorMessage(driver).getText();
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);
		assertEquals(fullNameErr, errorMessage);		
	}
	
	@Tag("contactUs")
	@Test
	void contactUsBlankEmail() throws InterruptedException {
		for (int i = 0; i < anipetWE.infoOptions(driver).size(); i++) {
			String optionX = anipetWE.infoOptions(driver).get(i).getText();
			if (optionX.equals(contact)) {
				anipetWE.infoOptions(driver).get(i).click();
			}else {
				continue;
			}
		}
		Thread.sleep(1000);
		anipetWE.CUName(driver).sendKeys(fullName);
		anipetWE.CUPhone(driver).sendKeys(phoneNum);
		anipetWE.CUMessage(driver).sendKeys(messageContent);
		anipetWE.CUSendBtn(driver).click();
		Thread.sleep(1500);
		String errorMessage = anipetWE.CUErrorMessage(driver).getText();
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);
		assertEquals(emailErr, errorMessage);
	}
	
	@Tag("contactUs")
	@Test
	void contactUsBlankPhoneNumber() throws InterruptedException {
		for (int i = 0; i < anipetWE.infoOptions(driver).size(); i++) {
			String optionX = anipetWE.infoOptions(driver).get(i).getText();
			if (optionX.equals(contact)) {
				anipetWE.infoOptions(driver).get(i).click();
			}else {
				continue;
			}
		}
		Thread.sleep(1000);
		anipetWE.CUName(driver).sendKeys(fullName);
		anipetWE.CUEmail(driver).sendKeys(email2);
		anipetWE.CUMessage(driver).sendKeys(messageContent);
		anipetWE.CUSendBtn(driver).click();
		Thread.sleep(1500);
		String errorMessage = anipetWE.CUErrorMessage(driver).getText();
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);
		assertEquals(phoneNumErr, errorMessage);
	}
	
	@Tag("itemDisplay")
	@Test
	void numberOfItemsDisplayed() throws InterruptedException {
		anipetWE.mainNavBar(driver).get(2).click();
		Thread.sleep(500);
		anipetWE.subCtgry(driver).get(2).click();
		Thread.sleep(500);
		for (int i = 0; i < anipetWE.itemsDisplayed(driver).size(); i++) {
			anipetWE.pageSize(driver).click();
			String display = anipetWE.itemsDisplayed(driver).get(i).getText();
			int displayNum = Integer.parseInt(display);
			anipetWE.itemsDisplayed(driver).get(i).click();
			Thread.sleep(500);
			int itemsOnScreen = anipetWE.itemsList(driver).size();
			assertEquals(displayNum, itemsOnScreen);
		}
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);
	}
	
	@Tag("shipment")
	@Test
	void freeShipmentAbove150() throws InterruptedException {
		anipetWE.freeShippingBtn(driver).click();
		Thread.sleep(500);
		for (int i = 0; i < anipetWE.FSCitiesList(driver).size(); i++) {
			anipetWE.FSPickCity(driver).click();
			anipetWE.FSCitiesList(driver).get(i).click();
			anipetWE.FSSumPay(driver).sendKeys(totalBuy);
			anipetWE.FSFreeCheckBtn(driver).click();
			Thread.sleep(200);
			String shipCostX = anipetWE.FSShipCost(driver).getText();
			assertEquals(shipCost, shipCostX);
		}
		
	}
	

}
