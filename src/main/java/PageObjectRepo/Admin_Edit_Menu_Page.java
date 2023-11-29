package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenricUtilities.WebdriverUtilities;

public class Admin_Edit_Menu_Page {
	
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
	
	@FindBy (xpath = "//input[@id='lastName']")
	private WebElement Image;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement UpdateMessageTxt;
	
	public WebElement getImage() {
		return Image;
	}

	public void setImage(WebElement image) {
		Image = image;
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
	
	
	public WebElement getUpdateMessageTxt() {
		return UpdateMessageTxt;
	}

	public Admin_Edit_Menu_Page  (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void EditMenu(String DishName, String Descripton, String Price, String Image_Path, WebdriverUtilities wUtil, String Rest_Name) {
		DishNameEdt.sendKeys(DishName);
		DescriptionEdt.sendKeys(Descripton);
		PriceEdt.sendKeys(Price);
		ImageEdt.sendKeys(Image_Path);
		wUtil.handleDropDown(Rest_Name, RestaurantDD);
		SaveBtn.click();
		
	}
	
	public void checkUpdateMessage (String expected) {
		
		String actualUpdateMessage = UpdateMessageTxt.getText();
		Assert.assertEquals(actualUpdateMessage, expected);
		
	}
	public void clickOnCancelBtn () {
		CancelBtn.click();
	}
	
	public String getEditedDishName (WebDriver driver, String DishName) {
		
		String EdtDishName = driver.findElement(By.xpath("//td[.='"+DishName+"']/../descendant::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).getText();
		return EdtDishName;
	}
	
	public void clickOnEditParticularDish (WebDriver driver, String DishName) {
		driver.findElement(By.xpath("//td[.='"+DishName+"']/../descendant::a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
		
	}

}
