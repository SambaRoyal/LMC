package letmecalltest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmentable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test_Base.TestBase;
import test_pages.Abhi;
import test_pages.AddressPage;
import test_pages.LocationPage;

import test_pages.LoginPage;
import test_pages.RestarentPage;
import test_util.TestUtil;

public class AbhirestaurantTest extends TestBase {
	public RestarentPage restrent;
	public Abhi abhi;
	public LoginPage login;
	public LocationPage locate;
	public AddressPage address;
	
	
	@Test(groups= {"samba"})
	public void loginTest() throws Exception {
		try {
			initialization();
			launch_browser(prop.getProperty("loginUrl"));
			TestUtil util=new TestUtil();
			Abhi abhi1 = new Abhi(driver);
			login=new LoginPage(driver);
        	login.loginClick();
			//util.clickElement1(LoginPage.login_link);
			util.inputtext(LoginPage.log_username,prop.getProperty("log_Email"));
			Reporter.log("Entered email address",true);
			util.inputtext(LoginPage.log_password, prop.getProperty("log_password"));
			Reporter.log("Entered password",true);
			
			util.clickElement1(LoginPage.log_btn);
			Reporter.log("Clicked on login button",true);
			
			locate.locationLink();
			
			util.clickElement1(RestarentPage.abhiRestaurant);
			
			util.clickElement1(abhi1.ROTIS);
			util.clickElement1(abhi1.JAWARROTI);
			
			 driver.close();
			
		} catch (Exception e1) {
			System.out.println("login error");
			e1.printStackTrace();
		}
	}

	

	@Test(groups= {"p1"})
	public void abhiRestaurentJawarRoti() {
		try {
			TestUtil util=new TestUtil();
			AbhirestaurantTest abhi=new AbhirestaurantTest();
			initialization();
			launch_browser(prop.getProperty("loginUrl"));
			restrent = new RestarentPage(driver);
			Abhi abhi1 = new Abhi(driver);
			util.clickElement1(RestarentPage.abhiRestaurant);
			util.clickElement1(Abhi.ROTIS);
			Thread.sleep(2000);
			//abhi.jawarrotiClick();
			// abhi.qtyDecBtnClick();
			// abhi.qtyincBtnClick();
		//	 abhi.qtyincBtnClick();
			//abhi.specialInstructionTextField(prop.getProperty("specialInstructionfield"));
		//	abhi.addToOrderclick();
		} catch (Exception e) {
			System.out.println("abhirestaurant error");
			e.printStackTrace();
		}
	}
		@Test(priority= 4,description="add to order")
   public void addressDetails() {
	address=new AddressPage(driver);
	try {
		
	
	address.deliveryCustomerNameText();
	address.continueToOrderSummery();
	}catch (Exception e) {
		System.out.println("deliveryCustomerDataFailed");
	e.printStackTrace();
	}	
	}

	@AfterTest
	public void teardown() {
		 driver.close();
	}
}
