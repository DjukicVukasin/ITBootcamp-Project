package stranice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Profile {
	
	public static final String URL = "https://imeprezime6.humanity.com/app/staff/edit/6357622/";
	public static final String PROFILESETTINGS_SELECTOR = "#userm > div > a:nth-child(5)";	
	public static final String FIRSTNAME_SELECTOR = "#first_name";
	public static final String LASTNAME_SELECTOR = "#last_name";
	public static final String SAVE_SELECTOR = "#act_primary";
	
	
	private static WebDriver driver; 
	
	@BeforeClass
	
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emmad\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	@Test
	
	public void profileSettings() {
		
		driver.navigate().to(PocetnaStranica.URL);
		PocetnaStranica.closePopUp(driver);
		PocetnaStranica.clickLogin(driver);
		PocetnaStranica.loginInputEmailorUsername(driver);
		PocetnaStranica.loginInputPassword(driver);
		PocetnaStranica.login(driver);
		
		driver.navigate().to(URL);

		
		//WebElement we = driver.findElement(By.cssSelector(PROFILESETTINGS_SELECTOR));
		//we.click();
		WebElement we2 = driver.findElement(By.cssSelector(FIRSTNAME_SELECTOR));
		we2.clear();
		we2.sendKeys("Ime");
		WebElement we3 = driver.findElement(By.cssSelector(FIRSTNAME_SELECTOR));
		we3.clear();
		we3.sendKeys("Prezime");
		WebElement we4 = driver.findElement(By.cssSelector(SAVE_SELECTOR));
		we4.click();
		driver.navigate().refresh();

		
	}

}
