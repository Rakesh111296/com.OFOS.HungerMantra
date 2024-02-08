package TestNG_Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenricUtilities.WebdriverUtilities;

public class windowPopTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[.='Open New Seperate Windows']")).click();
		driver.findElement(By.xpath("//div[@id='Seperate']/child::button")).click();
		String mainwindow =driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for(String lv:windows) {
			if (!mainwindow.equalsIgnoreCase(lv)) {
				
				driver.switchTo().window(lv);
				System.out.println("switched to child window");
				break;
			}
		
		}
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("(//i[@class='ps-3 fas fa-caret-right'])[2]"));
		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,950)", element);
		
		System.out.println("Pass");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Pass");
		
		//driver.findElement(By.xpath("//h4[.='Selenium WebDriver']/ancestor::div[@class='col-lg-4 mb-5 mb-lg-0 text-center bg-transparent']/descendant::a")).click();
		element.click();
		System.out.println("Pass");
		
		
		
		
	}
}
