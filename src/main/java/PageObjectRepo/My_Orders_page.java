package PageObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class My_Orders_page {

	@FindBy (xpath = "//th[.='Item']/following::tr/child::td[@data-column='Item']")
	private WebElement ItemText;
	
	public void getItemText() {
		ItemText.getText();
	}
	
	public int getCountOfOrders (WebDriver driver) {
		
		List<WebElement> element = driver.findElements(By.xpath("//th[.='Item']/following::tbody/descendant::td[@data-column='Item']"));
		int OrderCount = element.size();
		return OrderCount;
		
	}
	
	public void cancleParticularDish (WebDriver driver, String DishName) {
		driver.findElement(By.xpath("(//td[contains(text(),'"+DishName+"')])[1]/../child::td/child::a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
		
	}
	
	public void OrderCountAssert (int BeforeCount, int AfterCount) {
		
		Assert.assertNotEquals(BeforeCount, AfterCount, "Count Are Same");
		
	}
	
	
	}

	
	

