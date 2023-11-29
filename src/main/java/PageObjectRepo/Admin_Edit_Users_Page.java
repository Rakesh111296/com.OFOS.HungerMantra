package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenricUtilities.WebdriverUtilities;

public class Admin_Edit_Users_Page {

	@FindBy(name = "uname")
	private WebElement UsernameEdt;
	
	@FindBy(name = "fname")
	private WebElement FirstNameEdt;
	
	@FindBy(name = "lname")
	private WebElement LastNameEdt;
	
	@FindBy(name = "email")
	private WebElement EmailEdt;
	
	@FindBy(name = "phone")
	private WebElement PhoneEdt;
	
	@FindBy(name = "submit")
	private WebElement SaveBtn;
	
	@FindBy(linkText = "Cancel")
	private WebElement CancelBtn;
	
	public Admin_Edit_Users_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void editUserDetails (String UsernameEdit, String firstNameEdit, String LastNameEdit, String emailEdit, String phoneEdit) {
		UsernameEdt.sendKeys(UsernameEdit);
		FirstNameEdt.sendKeys(firstNameEdit);
		LastNameEdt.sendKeys(LastNameEdit);
		EmailEdt.sendKeys(emailEdit);
		PhoneEdt.sendKeys(phoneEdit);
		SaveBtn.click();
		
	}
	
	public void clickOnCancelBtn () {
		CancelBtn.click();
	}
}
