package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement HomeLink;

	@FindBy(xpath = "//a[contains(text(),'Restaurants')]")
	private WebElement RestaurantsLink;

	@FindBy(xpath = "//a[contains(text(),'My Orders')]")
	private WebElement MyOrdersLink;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement LogoutLink;

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeLink() {
		return HomeLink;
	}

	public WebElement getRestaurantsLink() {
		return RestaurantsLink;
	}

	public WebElement getMyOrdersLink() {
		return MyOrdersLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	/**
	 * This Method is Used to Logout The User
	 */
	public void LogOut() {
		LogoutLink.click();
	}

	/**
	 * This Method for Click on Home Tab
	 */
	public void HomeClick() {
		HomeLink.click();
	}

	/**
	 * This method is for Clicking on Restaurants Tab
	 */
	public void RestaurantsClick() {
		RestaurantsLink.click();
	}

	/**
	 * This Method is for Clicking on My Orders Tab
	 */
	public void MyOrdersClick() {
		MyOrdersLink.click();
	}

}
