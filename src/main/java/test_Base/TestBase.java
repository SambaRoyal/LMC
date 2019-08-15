package test_Base;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test_util.TestUtil;

public class TestBase {
	public static Properties prop;
	public static  WebDriver driver;

	public void initialization() throws Exception {
		prop = new Properties();

		FileInputStream file = new FileInputStream(
				"C:\\Testing master\\letmecall_1\\src\\main\\java\\configure\\configure_property");
		prop.load(file);

	}

	public void launch_browser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Testing master\\letmecall_1\\browser_Driver\\chromedriver.exe");
		// System.getProperty("user.dir") + "//browser_Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.switchTo().alert().dismiss();
		// driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pagewait, TimeUnit.SECONDS);
	}
	
}
