package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Admin_Dashboard_page {

	@FindBy(xpath = "//span[.='Users']")
	private WebElement UsersLink;

	@FindBy(xpath = "//span[.='Restaurant']")
	private WebElement RestaurantLink;

	@FindBy(xpath = "//a[.='All Restaurants']")
	private WebElement AllRestaurantLink;

	@FindBy(xpath = "//a[.='Add Category']")
	private WebElement AddCategoryLink;

	@FindBy(xpath = "//a[.='Add Restaurant']")
	private WebElement AddRestaurantLink;

	@FindBy(xpath = "//span[.='Menu']")
	private WebElement MenuLink;

	@FindBy(xpath = "//a[.='All Menues']")
	private WebElement AllMenuesLink;

	@FindBy(xpath = "//a[.='Add Menu']")
	private WebElement AddMenuLink;

	@FindBy(xpath = "//span[.='Orders']")
	private WebElement OrdersLink;

	@FindBy(xpath = "//span[.='Dashboard']")
	private WebElement DashboardLink;

	@FindBy(xpath = "//p[.='Restaurants']/../child::h2")
	private WebElement RestaurantsCount;

	@FindBy(xpath = "//p[.='Dishes']/../child::h2")
	private WebElement DishesCount;

	@FindBy(xpath = "//p[.='Users']/../child::h2")
	private WebElement UsersCount;

	@FindBy(xpath = "//p[.='Total Orders']/../child::h2")
	private WebElement TotalOrdersCount;

	@FindBy(xpath = "//p[.='Restro Categories']/../child::h2")
	private WebElement RestroCategoriesCount;

	@FindBy(xpath = "//p[.='Processing Orders']/../child::h2")
	private WebElement ProcessingOrdersCount;

	@FindBy(xpath = "//p[.='Delivered Orders']/../child::h2")
	private WebElement DeliveredOrdersCount;

	@FindBy(xpath = "//p[.='Cancelled Orders']/../child::h2")
	private WebElement CancelledOrdersCount;

	@FindBy(xpath = "//p[.='Total Earnings']/../child::h2")
	private WebElement TotalEarningsCount;

	@FindBy(xpath = "//img[@class='profile-pic']")
	private WebElement LogoutBtn;

	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement LogoutLink;

	public Admin_Dashboard_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}

	public WebElement getRestaurantLink() {
		return RestaurantLink;
	}

	public WebElement getAllRestaurantLink() {
		return AllRestaurantLink;
	}

	public WebElement getAddCategoryLink() {
		return AddCategoryLink;
	}

	public WebElement getAddRestaurantLink() {
		return AddRestaurantLink;
	}

	public WebElement getMenuLink() {
		return MenuLink;
	}

	public WebElement getAllMenuesLink() {
		return AllMenuesLink;
	}

	public WebElement getAddMenuLink() {
		return AddMenuLink;
	}

	public WebElement getOrdersLink() {
		return OrdersLink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getRestaurantsCount() {
		return RestaurantsCount;
	}

	public WebElement getDishesCount() {
		return DishesCount;
	}

	public WebElement getUsersCount() {
		return UsersCount;
	}

	public WebElement getTotalOrdersCount() {
		return TotalOrdersCount;
	}

	public WebElement getRestroCategoriesCount() {
		return RestroCategoriesCount;
	}

	public WebElement getProcessingOrdersCount() {
		return ProcessingOrdersCount;
	}

	public WebElement getDeliveredOrdersCount() {
		return DeliveredOrdersCount;
	}

	public WebElement getCancelledOrdersCount() {
		return CancelledOrdersCount;
	}

	public WebElement getTotalEarningsCount() {
		return TotalEarningsCount;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public void LogOut() {

		LogoutBtn.click();
		LogoutLink.click();

	}

	public void clickOnALlRestaurant() {

		RestaurantLink.click();
		AllRestaurantLink.click();

	}

	public void clickOnAddRestaurant() {
		RestaurantLink.click();
		AddRestaurantLink.click();
	}

	public void clickOnAddCategory() {
		RestaurantLink.click();
		AddCategoryLink.click();

	}
	
	public void clickOnAddMenu () {
		
		MenuLink.click();
		AddMenuLink.click();
	}

	public void clickOnALlMenu () {
		MenuLink.click();
		AllMenuesLink.click();
		
	}
	

	
}
