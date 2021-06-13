package testovi;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stranice.PocetnaStranica;
import stranice.Settings;
import stranice.VasaFirma;



public class Testovi {
	
	private static WebDriver driver; 
	
	private JavascriptExecutor js;



	
	@BeforeClass
	
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emmad\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
	}
	
	/*
	
	@Test (priority=0)
	
	public void testAboutUs() {
		
		

		
		driver.navigate().to(PocetnaStranica.URL);
		PocetnaStranica.closePopUp(driver);
		PocetnaStranica.clickMenu(driver);
		PocetnaStranica.clickAboutUs(driver);
		PocetnaStranica.screenshotAboutUs(driver);
		
		
		
	}
	
	
	@Test (priority=1)
	
	public void testLogin() {
		
		

		
		driver.navigate().to(PocetnaStranica.URL);
		//PocetnaStranica.closePopUp(driver);
		PocetnaStranica.clickLogin(driver);
		PocetnaStranica.loginInputEmailorUsername(driver);
		PocetnaStranica.loginInputPassword(driver);
		PocetnaStranica.login(driver);
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://imeprezime6.humanity.com/app/dashboard/");

	}
	
	
	




	@Test(priority=2)
	
	public void testVasaFirma() {
		
		
		
		
		SoftAssert sa = new SoftAssert();
		
		
		
		VasaFirma.clickDashboard(driver);
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = VasaFirma.URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		
		VasaFirma.clickShiftPlanning(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.SHIFTPLANNING_URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		
		VasaFirma.clickTimeClock(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.TIMECLOCK_URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		
		VasaFirma.clickLeave(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.LEAVE_URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		
		
		VasaFirma.clickTraining(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.TRAINING_URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		VasaFirma.clickStaff(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.STAFF_URL;
		
		sa.assertEquals(currentUrl, expectedUrl);
		
				 
		 VasaFirma.clickPayroll(driver);
			
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.PAYROLL_URL;
		 
		
		sa.assertEquals(currentUrl, expectedUrl);
		
		VasaFirma.clickReport(driver);
		
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.REPORT_URL;
		 
		 sa.assertEquals(currentUrl, expectedUrl);
		
		
		VasaFirma.clickAvailability(driver);
				
		 currentUrl = driver.getCurrentUrl();
		 expectedUrl = VasaFirma.AVAILABILITY_URL;
		 
		 sa.assertEquals(currentUrl, expectedUrl);
		 
		 String uniqueID = UUID.randomUUID().toString();
		 
		VasaFirma.addEmployee(driver, "Pera", "Peric", uniqueID + "@email.com");
		
		sa.assertTrue(driver.getPageSource().contains(uniqueID + "@email.com"));
		 
		
		VasaFirma.changeEmployeeName(driver);
		
		sa.assertAll();
		
		
		
		
	}
	
	

	
	@Test(priority=3)
	
	public void TestAddFiveEmployees() {
		
		driver.navigate().to(PocetnaStranica.URL);
		//PocetnaStranica.closePopUp(driver);
		//PocetnaStranica.clickLogin(driver);
		//PocetnaStranica.loginInputEmailorUsername(driver);
		//PocetnaStranica.loginInputPassword(driver);
		//PocetnaStranica.login(driver); 
		
		File f = new File("NewEmployees.xlsx");
		
		
		try {
			
			InputStream is = new FileInputStream(f);
			
			XSSFWorkbook wb = new XSSFWorkbook(is);
			
			SoftAssert sa = new SoftAssert();
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			for(int i = 0; i < 5; i++) {
				
				Row row = sheet.getRow(i);
				
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);
				
				String firstName = c0.toString();
				String lastName = c1.toString();
				String email = c2.toString();
				
				
				
				VasaFirma.addEmployee(driver, firstName, lastName, email);
				
				sa.assertTrue(driver.getPageSource().contains(email));
				
				
				
			}
			sa.assertAll();
			
			wb.close();
			
			
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	} 
	
	*/
	
	@Test (priority = 4)
	
	public void testChangeLanguage() {
		
		
		driver.navigate().to(PocetnaStranica.URL);
		PocetnaStranica.closePopUp(driver);
		PocetnaStranica.clickLogin(driver);
		PocetnaStranica.loginInputEmailorUsername(driver);
		PocetnaStranica.loginInputPassword(driver);
		PocetnaStranica.login(driver);
		
		//driver.navigate().to(VasaFirma.URL);
		
		SoftAssert sa = new SoftAssert();
		
		Settings.goToSettings(driver);
		Settings.selectLanguage(driver, "Croatian (machine)");
		
		Select select = new Select(driver.findElement(By.cssSelector(Settings.LANGUAGE_SELECTOR)));
		
		
		sa.assertEquals(select.getFirstSelectedOption().getText(), "Croatian (machine)");
		Settings.saveSettings(driver);
		
	}
	
	@Test (priority = 5)
	
	public void testNotifications() {
		
		js.executeScript("window.locaton = 'https://imeprezime6.humanity.com/app/admin/settings/'");
		
		
		
		
		
		WebElement element = driver.findElement(By.cssSelector(Settings.EMAIL_NOTF_SELECTOR));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		js.executeScript("window.scrollBy(0, -300);");
		
				
		Settings.noNotifications(driver);
		
		
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(!driver.findElement(By.cssSelector(Settings.EMAIL_NOTF_SELECTOR)).isSelected());		
		sa.assertTrue(!driver.findElement(By.cssSelector(Settings.SMS_NOTF_SELECTOR)).isSelected());
		sa.assertTrue(!driver.findElement(By.cssSelector(Settings.MOB_NOTF_SELECTOR)).isSelected());
		sa.assertAll();
		
		Settings.saveSettings(driver);
	}
	
}
