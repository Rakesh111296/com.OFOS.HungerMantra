package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu_Page {

	@FindBy(linkText = "Checkout")
	private WebElement CheckOutBt;

	@FindBy(tagName = "title")
	private WebElement Title;
	
	@FindBy (xpath = "//a[.='Choose Restaurant']")
	private WebElement chooseRestaurantLnk;

	public Menu_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckOutBt() {
		return CheckOutBt;
	}

	public WebElement getTitle() {
		return Title;
	}

	public void clickCheckOut() {

		CheckOutBt.click();
	}
	
	
	public WebElement getChooseRestaurantLnk() {
		return chooseRestaurantLnk;
	}

	public void clear_Add_Qty_And_Add_Cart (WebDriver driver, String DishName) {
		driver.findElement(By.xpath(
				"(//a[.='"+DishName+"'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.clear();
		driver.findElement(By.xpath(
				"(//a[.='"+DishName+"'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='text']"))
				.sendKeys("2");

		driver.findElement(By.xpath(
				"(//a[.='"+DishName+"'])[1]/ancestor::div[@class='food-item']/descendant::input[@type='submit']"))
				.click();
	}

}
