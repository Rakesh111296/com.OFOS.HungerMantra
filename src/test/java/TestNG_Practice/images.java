package TestNG_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class images {

	public static void main(String[] args) {
	       
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Amazon web application
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Find all image elements on the page
        List<WebElement> images = driver.findElements(By.tagName("img"));

        // Iterate through each image and check if it's broken
        for (WebElement image : images) {
            String imageURL = image.getAttribute("src");
            System.out.println(imageURL);
        }

        // Close the browser
        driver.quit();
    }
}
