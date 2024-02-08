package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class broken_image {



	 public static void main(String[] args) {
	       
	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the Amazon web application
	        driver.get("https://www.flipkart.com/");

	        // Find all image elements on the page
	        List<WebElement> images = driver.findElements(By.tagName("img"));

	        // Iterate through each image and check if it's broken
	        for (WebElement image : images) {
	            String imageURL = image.getAttribute("src");
	            if (isImageBroken(imageURL)) {
	                System.out.println("Broken Image Found: " + imageURL);
	            }
	        }

	        // Close the browser
	        driver.quit();
	    }

	    // Function to check if an image is broken
	    private static boolean isImageBroken(String imageURL) {
	        WebDriver driver = new ChromeDriver();

	        // Load the image URL in a separate WebDriver instance
	        driver.get(imageURL);

	        // Check if the page contains the string "404" (assumes broken images return a 404 status)
	        boolean isBroken = driver.getPageSource().contains("404");

	        // Close the WebDriver instance
	        driver.quit();

	        return isBroken;
	    }
}
	

	
	

