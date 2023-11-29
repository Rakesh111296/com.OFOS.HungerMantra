package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	@FindBy(xpath = "//a[.='Login']")
	private WebElement LoginLink;

	@FindBy(name = "username")
	private WebElement UserNameTxt;

	@FindBy(name = "password")
	private WebElement PasswordTxt;

	@FindBy(name = "submit")
	private WebElement LoginBtn;

	@FindBy(xpath = "//a[@class='nav-link active']")
	private WebElement TitleLnk;
	

	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public WebElement getUserNameTxt() {
		return UserNameTxt;
	}

	public WebElement getPasswordTxt() {
		return PasswordTxt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getTitleLnk() {
		return TitleLnk;
	}
	
	

	/**
	 * This Method is for Login To the Application
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void logintoapp(String USERNAME, String PASSWORD) {
		LoginLink.click();
		UserNameTxt.sendKeys(USERNAME);
		PasswordTxt.sendKeys(PASSWORD);
		LoginBtn.click();
	}

}
