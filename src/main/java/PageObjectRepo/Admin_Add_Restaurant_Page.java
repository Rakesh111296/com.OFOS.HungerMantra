package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenricUtilities.WebdriverUtilities;

public class Admin_Add_Restaurant_Page {

	
	@FindBy(name = "res_name")
	private WebElement RestaurantNameEdt;

	@FindBy(name = "email")
	private WebElement BussinessEmailEdt;

	@FindBy(name = "phone")
	private WebElement phoneEdt;

	@FindBy(name = "url")
	private WebElement urlEdt;

	@FindBy(name = "o_hr")
	private WebElement OpenHoursDD;

	@FindBy(name = "c_hr")
	private WebElement closingHoursDD;

	@FindBy(name = "o_days")
	private WebElement OpenDaysDD;

	@FindBy(name = "c_name")
	private WebElement CategoryDD;

	@FindBy(name = "file")
	private WebElement ImageEdt;

	@FindBy(name = "address")
	private WebElement AddressEdt;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement ConfirmationMessege;

	@FindBy(name = "submit")
	private WebElement SaveBtn;

	@FindBy(linkText = "Cancel")
	private WebElement CancelBtn;

	public Admin_Add_Restaurant_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Add_Restaurant(String Rest_Name, String Email_Edt, String Phone_Edt, String Website_Edt,
			WebdriverUtilities wUtil, String Open_Hours, String Close_hours, String Open_Days, String category,
			String Image_path, String Address_Edt) {
		RestaurantNameEdt.sendKeys(Rest_Name);
		BussinessEmailEdt.sendKeys(Email_Edt);
		phoneEdt.sendKeys(Phone_Edt);
		urlEdt.sendKeys(Website_Edt);
		wUtil.handleDropDown(Open_Hours, OpenHoursDD);
		wUtil.handleDropDown(Close_hours, closingHoursDD);
		wUtil.handleDropDown(Open_Days, OpenDaysDD);
		wUtil.handleDropDown(category, CategoryDD);
		ImageEdt.sendKeys(Image_path);
		AddressEdt.sendKeys(Address_Edt);
		SaveBtn.click();

	}
	
	public void clickOnCancelBtn () {
		CancelBtn.click();
	}

	
	public String  getConfermationMessge () {
		String confMessege = ConfirmationMessege.getText();
		return confMessege;
	}
	
	public void clickEditRestBtn (WebDriver driver, String EdtRestName) {
		driver.findElement(By.xpath("//td[.='" +EdtRestName+ "']/../child::td/child::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
	}
	
	public void checkConfirmMessage(String expected) {
		String confMessege = ConfirmationMessege.getText();
		Assert.assertEquals(confMessege, expected);
	}
}


