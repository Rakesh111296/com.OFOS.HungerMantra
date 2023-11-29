package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Restaurants_Page {
	
	@FindBy (xpath = "//h5/child::a")
	private WebElement RestaurantText;
	
	public Restaurants_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRestaurantText() {
		return RestaurantText;
	}
	
	public void clickPaticularRestaurant (WebDriver driver, String RestName) {
		
		driver.findElement(By.xpath("//a[.='" + RestName + "']")).click();
	}
	
	
}
