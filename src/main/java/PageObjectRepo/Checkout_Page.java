package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Page {

	@FindBy (name = "submit")
	private WebElement OrderNowBtn;
	
	public Checkout_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderNow () 
	{
		OrderNowBtn.click();
	}
	
	
}
