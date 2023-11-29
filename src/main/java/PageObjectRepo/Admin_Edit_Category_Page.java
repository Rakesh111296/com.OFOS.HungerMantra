package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Edit_Category_Page {

	
	@FindBy(name = "c_name")
	private WebElement CategoryEdt;
	
	@FindBy(name = "submit")
	private WebElement SaveBtn;

	@FindBy(linkText = "Cancel")
	private WebElement CancelBtn;
	
	public Admin_Edit_Category_Page  (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Edit_Category(String Category_Name) {
		CategoryEdt.sendKeys(Category_Name);
		SaveBtn.click();
	}
	
	public void clickOnCancelBtn () {
		CancelBtn.click();
	}
}
