package stranice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Settings {
	
	public static final String SETTINGS_SELECTOR = "#sn_admin";
	public static final String SETTINGS_URL = "https://imeprezime6.humanity.com/app/admin/settings/";
	
	public static final String LANGUAGE_SELECTOR = "#adminSettingsForm > div.profile_tile.hide.asettings.asetting_local > table > tbody > tr:nth-child(3) > td.nowrap > select";
	
	public static final String EMAIL_NOTF_SELECTOR = "#pref_pref_email";
	public static final String SMS_NOTF_SELECTOR = "#pref_pref_sms";
	public static final String MOB_NOTF_SELECTOR = "#pref_pref_mobile_push";
	
	
	public static final String SAVE_SELECTOR = "#act_primary";
	
	
	
	
	public static void goToSettings(WebDriver driver) {
		
		WebElement we = driver.findElement(By.cssSelector(SETTINGS_SELECTOR));
		we.click();
		
	}
	
	public static void selectLanguage(WebDriver driver, String language){
		
		//WebElement we = driver.findElement(By.cssSelector(LANGUAGE_SELECTOR));
		//we.click();
		
		Select dropSort = new Select(driver.findElement(By.cssSelector(LANGUAGE_SELECTOR)));
		
		 
		dropSort.selectByVisibleText(language);
		//dropSort.selectByIndex(6);
		//driver.findElement(By.cssSelector(LANGUAGE_SELECTOR)).sendKeys(Keys.ENTER);
		
	

	}
	
	public static void noNotifications(WebDriver driver ) {
		
		
		
		WebElement we = driver.findElement(By.cssSelector(EMAIL_NOTF_SELECTOR));
		we.click();
		WebElement we2 = driver.findElement(By.cssSelector(SMS_NOTF_SELECTOR));
		we2.click();
		WebElement we3 = driver.findElement(By.cssSelector(MOB_NOTF_SELECTOR));
		we3.click();
		
		
				
	}
	
	public static void saveSettings(WebDriver driver) {
		
		WebElement we = driver.findElement(By.cssSelector(SAVE_SELECTOR));
		we.click();
		driver.navigate().refresh();

		
	}
	
	
	
	
	
	

}
