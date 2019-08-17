package test_util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import test_Base.TestBase;
import test_pages.LoginPage;

public class TestUtil extends TestBase {

	public static long pagewait = 20;
	public static long implicit = 20;

	public static void mouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(@class,'mega dropdown')]"))).build().perform();

	}
	public void itemMouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='fromDate']"))).build().perform();
	}
   public  void dropdown() {
	   Select dropdown=new Select(driver.findElement(By.xpath("")));
	   
   }
   public static void screenShots() throws IOException {
	 File fo=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(fo, new File("C:\\Users\\welcome\\Downloads\\screenshot.png"));
   }  
   
   public static void windowHandle() {
   for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
				}
   }
   public static void fromDate() {
	   driver.findElement(By.xpath("//*[@id='fromDate']")).click();
	  
   }
   public void clickElement1(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver ,1000) ;
        wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   public void inputtext(WebElement element ,String text) {
		WebDriverWait wait = new WebDriverWait(driver , 1000) ;
       wait.until(ExpectedConditions.textToBePresentInElement(element, text));
   }

}
