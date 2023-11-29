package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login_Page {

	@FindBy(name = "username")
	private WebElement AdminUserEdt;

	@FindBy(name = "password")
	private WebElement AdminPasswordEdt;

	@FindBy(name = "submit")
	private WebElement AdminLoginBtn;

	public Admin_Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AdminLogin(String ADMINUSERNAME, String ADMINPASSWORD) {
		AdminUserEdt.sendKeys(ADMINUSERNAME);
		AdminPasswordEdt.sendKeys(ADMINPASSWORD);
		AdminLoginBtn.click();

	}

}
