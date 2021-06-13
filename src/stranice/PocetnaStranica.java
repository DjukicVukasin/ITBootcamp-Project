package stranice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class PocetnaStranica {

	public static final String URL = "https://www.humanity.com./";
	public static final String ABOUT_US_XPATH = "/html/body/div[7]/ul/li[7]/a";
	public static final String POPUP_CLOSE_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
	public static final String MENU_XPATH = "//*[@id=\"sm_menu_ham\"]";
	public static final String USERNAME_EMAIL_XPATH = "//*[@id=\"email\"]";
	public static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	
	public static final String CLICKLOGIN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	public static final String LOGIN_XPATH = "//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
	
	
	
	public static void closePopUp(WebDriver driver) {
		
		WebElement we = driver.findElement(By.xpath(POPUP_CLOSE_XPATH));
		we.click();
		
	}
	
	public static void clickMenu (WebDriver driver) {
		
		
		WebElement we = driver.findElement(By.xpath(MENU_XPATH));
		we.click();
		
	}
	
	
	public static void clickAboutUs(WebDriver driver) {
		
		WebElement we = driver.findElement(By.xpath(ABOUT_US_XPATH));
		we.click();
		
		
		
	}
	
	public static void screenshotAboutUs (WebDriver driver) {
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotFile, new File("C:\\\\Users\\\\emmad\\\\Desktop\\\\skrinsot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void loginInputPassword (WebDriver driver) {
		
		
		WebElement we = driver.findElement(By.xpath(PASSWORD_XPATH));
		we.sendKeys("sifra123");
		
			
		
		
		
		
	}
	
	public static void loginInputEmailorUsername (WebDriver driver) {
		
		
		WebElement we2 = driver.findElement(By.xpath(USERNAME_EMAIL_XPATH));
		we2.sendKeys("prezime.ime15@gmail.com");
		
	}
	
	
	
	
	
	
	
	public static void clickLogin (WebDriver driver) {
		
		driver.manage().window().maximize();
		WebElement we = driver.findElement(By.xpath(CLICKLOGIN_XPATH));
		we.click();
	
	
	

}
	public static void login (WebDriver driver) {
		
		try {
		
		WebElement we = driver.findElement(By.xpath(LOGIN_XPATH));
		we.click();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
