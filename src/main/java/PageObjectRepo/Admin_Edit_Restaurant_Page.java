package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenricUtilities.WebdriverUtilities;

public class Admin_Edit_Restaurant_Page {

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

	@FindBy(name = "submit")
	private WebElement SaveBtn;

	@FindBy(linkText = "Cancel")
	private WebElement CancelBtn;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement ConfirmMessage;

	public Admin_Edit_Restaurant_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getRestaurantNameEdt() {
		return RestaurantNameEdt;
	}

	public WebElement getBussinessEmailEdt() {
		return BussinessEmailEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getUrlEdt() {
		return urlEdt;
	}

	public WebElement getOpenHoursDD() {
		return OpenHoursDD;
	}

	public WebElement getClosingHoursDD() {
		return closingHoursDD;
	}

	public WebElement getOpenDaysDD() {
		return OpenDaysDD;
	}

	public WebElement getCategoryDD() {
		return CategoryDD;
	}

	public WebElement getImageEdt() {
		return ImageEdt;
	}

	public WebElement getAddressEdt() {
		return AddressEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	
	public void Edit_Restaurant(String Rest_Name, String Email_Edt, String Phone_Edt, String Website_Edt,
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
	
	public WebElement getConfirmMessage() {
		return ConfirmMessage;
	}

	public void updateConfirmAssert (String expectedUpdate) {
		String ActualEdt = ConfirmMessage.getText();
		Assert.assertEquals(ActualEdt, expectedUpdate);
	}
	
}
