package letmecalltest;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test_Base.TestBase;
import test_pages.LocationPage;
import test_pages.LoginPage;

public class LocationPageTest extends TestBase{
	LoginPage login;
	LocationPage location;
	@Test
	public void LocationTest() {
		try {
			initialization();
			launch_browser(prop.getProperty("loginUrl"));
			Thread.sleep(5000);
			location=new LocationPage(driver);
			login = new LoginPage(driver);
			login.login_link.click();
			//login.loginClick();
			Reporter.log("login link click", true);
			login.log_username.sendKeys(prop.getProperty("log_Email"));
			Reporter.log("Enter User name", true);
			Thread.sleep(3000);
			login.log_password.sendKeys(prop.getProperty("log_Pwd"));
			//login.PWD();
			Reporter.log("Enter password", true);
			login.log_btn.click();
			Reporter.log("login click", true);
			//location.locationLink();
			Thread.sleep(5000);
			location.searchbox.sendKeys("LB nagar");
			location.searchbox.sendKeys(Keys.ARROW_DOWN);
			location.searchbox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
