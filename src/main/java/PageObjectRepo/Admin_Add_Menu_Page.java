package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenricUtilities.WebdriverUtilities;

public class Admin_Add_Menu_Page {

	
	@FindBy(name = "d_name")
	private WebElement DishNameEdt;
	
	@FindBy(name = "about")
	private WebElement DescriptionEdt;
	
	@FindBy(name = "price")
	private WebElement PriceEdt;
	
	@FindBy(name = "file")
	private WebElement ImageEdt;
	
	@FindBy(name = "res_name")
	private WebElement RestaurantDD;
	
	@FindBy(name = "submit")
	private WebElement SaveBtn;

	@FindBy(linkText = "Cancel")
	private WebElement CancelBtn;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement ConfirmationMessageTxt;
	
	
	
	public Admin_Add_Menu_Page  (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addMenu(String DishName, String Descripton, String Price, String Image_Path, WebdriverUtilities wUtil, String Rest_Name) {
		DishNameEdt.sendKeys(DishName);
		DescriptionEdt.sendKeys(Descripton);
		PriceEdt.sendKeys(Price);
		ImageEdt.sendKeys(Image_Path);
		wUtil.handleDropDown(Rest_Name, RestaurantDD);
		SaveBtn.click();
		
	}
	
	
	public WebElement getDishNameEdt() {
		return DishNameEdt;
	}

	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}

	public WebElement getPriceEdt() {
		return PriceEdt;
	}

	public WebElement getImageEdt() {
		return ImageEdt;
	}

	public WebElement getRestaurantDD() {
		return RestaurantDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getConfirmationMessageTxt() {
		return ConfirmationMessageTxt;
	}
	

	public void clickOnCancelBtn () {
		CancelBtn.click();
	}
	
	
	public void checkConfirm (String expected) {
		
		String actualMessage = ConfirmationMessageTxt.getText();
		Assert.assertEquals(actualMessage, expected);
		
	}
}
