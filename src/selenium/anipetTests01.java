package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class anipetTests01 {

	static WebDriver driver;
	static String homeTitle = "????? ??? ?????? ????? ????";
	static String homeName = "anipet";
	static String homeURL = "https://www.anipet.co.il/";
	static String fName = "????";
	static String lName = "???";
	static String fullName = "??? ???";
	static String email = "yossiCohen1717@walla.com";
	static String email2 = "yossillll2122@mailinator.com"; // needs to be changed each 'signUp' run to a new address
	static String pass = "yossi123";
	static String phoneNum = "0581111111";
	static String messageContent = "aaaaaaaaaaaaa";
	static String fNameErr = "??? ???? ?? ????";
	static String lNameErr = "??? ???? ?? ?????";
	static String fullNameErr = "??? ??? ??";
	static String emailErr = "??? ??? ???? ????????";
	static String passErr = "??? ??? ?????; ??? ????? ?????? ?? ???? ??????";
	static String passConfErr = "??? ????? ?????? ?? ???? ??????";
	static String wrongDitsErr = "????? ???????? ?? ?????? ????? ?? ??????. ??? ??? ???";
	static String phoneNumErr = "??? ??? ??' ?????";
	static String persArea = "???? ????";
	static String logOut = "?????";
	static String exstUser = "User name '" + email2 + "' is already taken."; // email needs to be changed according to 'email2'
	static String srchObject = "????";
	static String nextPageSign = "?";
	static String contact = "??? ???";
	static String totalBuy = "150";
	static String shipCost = "????";
	static String facebookURL = "https://www.facebook.com/anipet.stores/";
	static String instagramURL = "https://www.instagram.com/anipet_israel/";
	
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

	@Tag("homePageGUI")
	@Test
	void titleTest() {
		String title = driver.getTitle();
		assertEquals(homeTitle, title);
	}
	
	@Tag("homePageGUI")
	@Test
	void homePageBtnTest() throws InterruptedException {
		for (int i = 0; i < anipetWE.mainNavBar(driver).size()-2; i++) {
			anipetWE.mainNavBar(driver).get(i).click();
			anipetWE.homePageBtn(driver).click();
			String pageURL = driver.getCurrentUrl();
			assertEquals(homeURL, pageURL);
		}
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);
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
			String priceStr = anipetWE.itemsListPrices(driver).get(i).getText().replace("?", "");
			int price = Integer.parseInt(priceStr);
			sumBuy += price;
		}
		System.out.println("Expected sum of the first 3 items: " + sumBuy + "?");
		for (int i = 0; i < 3; i++) {
			anipetWE.add2CartBtns(driver).get(i).click();
			Thread.sleep(1200);
			anipetWE.cartXBtn(driver).click();
			Thread.sleep(1200);
		}
		Thread.sleep(1000);
		anipetWE.mainNavBar(driver).get(8).click();
		Thread.sleep(2000);
		String totalPayStr = anipetWE.totalPayment(driver).getText().replace("?", "").replace(".00", "");
		int totalPay = Integer.parseInt(totalPayStr);
		System.out.println("Actual sum of the first 3 items: " + totalPay + "?");
		anipetWE.cartXBtn(driver).click();
		Thread.sleep(1000);
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
		int failSum = 0;
		for (int i = 1; i < anipetWE.FSCitiesList(driver).size(); i++) {
			anipetWE.FSPickCity(driver).click();
			String cityX = anipetWE.FSCitiesList(driver).get(i).getText();
			anipetWE.FSCitiesList(driver).get(i).click();
			anipetWE.FSSumPay(driver).clear();
			anipetWE.FSSumPay(driver).sendKeys(totalBuy);
			anipetWE.FSFreeCheckBtn(driver).click();
			Thread.sleep(1000);
			String shipCostX = anipetWE.FSShipCost(driver).getAttribute("value");
			if (shipCostX.equals(shipCost)) {
				continue;
			}else {
				System.out.println(i + ". " + cityX + " doesn't have free shipping for order of 150?");
				failSum += 1;
				continue;
			}
		}
		int cities = anipetWE.FSCitiesList(driver).size();
		System.out.println(failSum + " fails out of " + cities);
		Thread.sleep(500);
		anipetWE.mainNavBar(driver).get(0).click();
		Thread.sleep(500);		
	}
	
	@Tag("socialMedia")
	@Test
	void socialMediaLinks() throws InterruptedException {
		anipetWE.socialMediaBtnList(driver).get(0).click();
		Thread.sleep(500);
		String fbURL = driver.getCurrentUrl();
		if (fbURL.equals(facebookURL)) {
			System.out.println("Facebook URL - OK");
		}else {
			System.err.println("Facebook URL - NOT OK");
		}
		driver.get(homeURL);
		Thread.sleep(500);
		anipetWE.socialMediaBtnList(driver).get(1).click();
		Thread.sleep(500);
		String instaURL = driver.getCurrentUrl();
		if (instaURL.equals(instagramURL)) {
			System.out.println("Instagram URL - OK");
		}else {
			System.err.println("Instagram URL - NOT OK");
		}
		driver.get(homeURL);
		Thread.sleep(500);
	}
	
	@Tag("brands")
	@Test
	void brandLinks() throws InterruptedException {
		for (int i = 0; i < anipetWE.brandUrls(driver).size(); i++) {
			String nameX = anipetWE.brandNames(driver).get(i).getText();
			try {
				anipetWE.brandUrls(driver).get(i).click();
				System.out.println("Clicked on " + nameX);
				Thread.sleep(1000);
			}catch (Exception e) {
				System.err.println("Problen with clicking on " + nameX);
			}			
			try {
				for (int j = 0; j < anipetWE.brandRes(driver).size(); j++) {
					String resNameX = anipetWE.brandRes(driver).get(j).getAttribute("text");
					if (resNameX.contains(nameX)) {
						continue;
					}else {
						System.err.println("Check result #" + (j+1) + " in brand name - " + nameX);
						continue;
					}
				}
				System.out.println("Finished with " + nameX);
			} catch (Exception e) {
				
			}			
			driver.get(homeURL);
			Thread.sleep(500);			
		}
	}
	

}
