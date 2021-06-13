package stranice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;


import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	


public class VasaFirma {
	
	//public static final String uniqueID = UUID.randomUUID().toString();

	public static final String URL = "https://imeprezime6.humanity.com/app/dashboard/";
	public static final String DASHBOARD_XPATH = "//*[@id=\"sn_dashboard\"]/span/p";
	public static final String SHIFTPLANNING_XPATH = "//*[@id=\"sn_schedule\"]/span";
	public static final String SHIFTPLANNING_URL = "https://imeprezime6.humanity.com/app/schedule/employee/week/overview/overview/7%2c5%2c2021/";
	public static final String TIMECLOCK_XPATH = "//*[@id=\"sn_timeclock\"]/span";
	public static final String TIMECLOCK_URL = "https://imeprezime6.humanity.com/app/timeclock/";
	public static final String SHIFTPLANNINGDATE_XPATH = "//*[@id=\"cp_cal\"]/div/div/div[2]/div[2]/div[2]/div[2]";
	public static final String LEAVE_XPATH = "//*[@id=\"sn_requests\"]/span";
	public static final String LEAVE_URL = "https://imeprezime6.humanity.com/app/requests/vacation/";
	public static final String TRAINING_XPATH = "//*[@id=\"sn_training\"]/span";
	public static final String TRAINING_URL = "https://imeprezime6.humanity.com/app/training/";
	public static final String STAFF_URL = "https://imeprezime6.humanity.com/app/staff/list/load/true/";
	public static final String STAFF_XPATH = "//*[@id=\"sn_staff\"]/span";
	public static final String AVAILABILITY_URL = "https://imeprezime6.humanity.com/fe/availability/";
	public static final String AVAILABILITY_XPATH = "//*[@id=\"sn_availability\"]/span";
	public static final String PAYROLL_SELECTOR = "#sn_payroll > span";
	public static final String PAYROLL_URL = "https://imeprezime6.humanity.com/app/payroll/scheduled-hours/";
	public static final String REPORT_URL = "https://imeprezime6.humanity.com/app/reports/dashboard/";
	public static final String REPORT_XPATH = "//*[@id=\"sn_reports\"]/span";
	public static final String ADDEMPLOYEE_XPATH = "//*[@id=\"act_primary\"]";
	public static final String ADDEMPLOYEE_FIRSTNAME_XPATH = "//*[@id=\"_asf1\"]";
	public static final String ADDEMPLOYEE_LASTNAME_XPATH = "//*[@id=\"_asl1\"]";
	public static final String ADDEMPLOYEE_EMAIL_XPATH = "//*[@id=\"_ase1\"]";
	public static final String ADDEMPLOYEE_SAVE_XPATH = "//*[@id=\"_as_save_multiple\"]";
	public static final String ALLEMPLOYEES_XPATH = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
	public static final String ALLEMPLOYEES_SELECTOR = "#StaffSchedules > ul.lMenuHolder > li:nth-child(1) > a";
	public static final String ALLEMPLOYEES_FIELD_XPATH = "//*[@id=\"staff-filters-container\"]/div/div[4]/div[1]";
	public static final String APPLYFIELD_XPATH = "//*[@id=\"staff-filters-container\"]/div/div[4]/div[2]/div/button[1]";
	public static final String FIRST_EMPLOYEE_XPATH = "//*[@id=\"7\"]/a";
	public static final String EDIT_EMPLOYEE_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String EDIT_EMPLOYEE_FNAME_SELECTOR = "#first_name";  
	public static final String EDIT_EMPLOYEE_LNAME_SELECTOR = "#last_name";
	public static final String EDIT_EMPLOYEE_SAVE = "#act_primary";
	public static final String UPLOAD_PHOTO_SELECTOR = "#in-btn";
	public static final String UPLOAD_PHOTO_XPATH = "//*[@id=\"in-btn\"]";
	
	
	
	
	public static void clickDashboard(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(DASHBOARD_XPATH));
		we.click();

	}

	public static void clickShiftPlanning(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(SHIFTPLANNING_XPATH));
		we.click();
		WebElement we2 = driver.findElement(By.xpath(SHIFTPLANNINGDATE_XPATH));
		we2.click();

	}

	public static void clickTimeClock(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(TIMECLOCK_XPATH));
		we.click();

	}

	public static void clickLeave(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(LEAVE_XPATH));
		we.click();

	}

	public static void clickTraining(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(TRAINING_XPATH));
		we.click();

	}

	public static void clickStaff(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(STAFF_XPATH));
		we.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void clickAvailability(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(AVAILABILITY_XPATH));
		we.click();

	}

	public static void clickPayroll(WebDriver driver) {

		WebElement we = driver.findElement(By.cssSelector(PAYROLL_SELECTOR));
		we.click();

	}

	public static void clickReport(WebDriver driver) {

		WebElement we = driver.findElement(By.xpath(REPORT_XPATH));
		we.click();

	}

	public static void addEmployee(WebDriver driver, String name, String lastName, String email) {

		driver.navigate().to(VasaFirma.STAFF_URL);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement we = driver.findElement(By.xpath(ADDEMPLOYEE_XPATH));
		we.click();
		WebElement we2 = driver.findElement(By.xpath(ADDEMPLOYEE_FIRSTNAME_XPATH));
		we2.sendKeys(name);
		WebElement we3 = driver.findElement(By.xpath(ADDEMPLOYEE_LASTNAME_XPATH));
		we3.sendKeys(lastName);
		
		
		
		WebElement we4 = driver.findElement(By.xpath(ADDEMPLOYEE_EMAIL_XPATH));
		
		
		//String uniqueID = UUID.randomUUID().toString();
		// uniqueID + "@email.com"
		
		
		we4.sendKeys(email);
		
		
		
		WebElement we5 = driver.findElement(By.xpath(ADDEMPLOYEE_SAVE_XPATH));
		we5.click();
		driver.navigate().refresh();
		WebElement we6 = driver.findElement(By.cssSelector(ALLEMPLOYEES_SELECTOR));
		we6.click();
		
	}
	
	public static void changeEmployeeName(WebDriver driver) {
		
		
		
		
		WebElement we = driver.findElement(By.xpath(FIRST_EMPLOYEE_XPATH));
		we.click();
		WebElement we2 = driver.findElement(By.xpath(EDIT_EMPLOYEE_XPATH));
		we2.click();
		WebElement we3 = driver.findElement(By.cssSelector(EDIT_EMPLOYEE_FNAME_SELECTOR));
		we3.click();
		we3.clear();
		we3.sendKeys("Name");
		WebElement we4 = driver.findElement(By.cssSelector(EDIT_EMPLOYEE_LNAME_SELECTOR));
		we4.click();
		we4.clear();
		we4.sendKeys("LastName");
		WebElement we5 = driver.findElement(By.cssSelector(EDIT_EMPLOYEE_SAVE));
		we5.click();
	}

	
	
	
	
	

}
