package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricBuzz_test {

	 public static void main(String[] args) {
	        
	        // Initialize the WebDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the Cricbuzz homepage
	        driver.get("https://www.cricbuzz.com/live-cricket-scores/79181/saus-vs-ql-12th-match-sheffield-shield-2023-24");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        List<WebElement> BatsmenNameList = driver.findElements(By.xpath("(//div[.='Batter'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::a[@class='cb-text-link ng-binding']"));       
	        List<WebElement> Runs = driver.findElements(By.xpath("(//div[.='R'])/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='batsmen.batRuns']"));
	        List<WebElement> Balls = driver.findElements(By.xpath("(//div[.='B'])/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='batsmen.batBalls']"));
	        List<WebElement> No_4s = driver.findElements(By.xpath("(//div[.='4s'])/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='batsmen.batFours']"));
	        List<WebElement> No_6s = driver.findElements(By.xpath("(//div[.='6s'])/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='batsmen.batSixes']"));
	        List<WebElement> StrikeRate = driver.findElements(By.xpath("(//div[.='SR'])/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='batsmen.batStrikeRate|number: 2']"));
	        int listSize = BatsmenNameList.size();
	        System.out.println("Batsman :");
	        for (int i = 0; i < listSize; i++) {
	        	
	        	String Concat = BatsmenNameList.get(i).getText()+"----"+Runs.get(i).getText()+"----"+Balls.get(i).getText()+"----"+No_4s.get(i).getText()+"----"+No_6s.get(i).getText()+"----"+StrikeRate.get(i).getText();
	        	System.out.println(Concat);
	        }
	 
	        List<WebElement> BowllerNameList = driver.findElements(By.xpath("(//div[.='Bowler'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::a[@class='cb-text-link ng-binding']"));
	        List<WebElement> Overs = driver.findElements(By.xpath("(//div[.='O'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='bowler.bowlOvs']"));
	        List<WebElement> BowlMaidens = driver.findElements(By.xpath("(//div[.='M'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='bowler.bowlMaidens']"));
	        List<WebElement> BowlRuns = driver.findElements(By.xpath("(//div[.='M'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='bowler.bowlRuns']"));
	        List<WebElement> Wickets = driver.findElements(By.xpath("(//div[.='M'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='bowler.bowlWkts']"));
	        List<WebElement> Economy  = driver.findElements(By.xpath("(//div[.='M'])[2]/ancestor::div[@class='cb-min-inf cb-col-100 ng-scope']/descendant::div[@ng-bind='bowler.bowlEcon|number: 2']"));
	 
	        
	        int listSize1 = BowllerNameList.size();
	        System.out.println("Bowller :");
	        for (int i = 0; i < listSize1; i++) {
	        	
	        	String Concat1 = BowllerNameList.get(i).getText()+"----"+Overs.get(i).getText()+"----"+BowlMaidens.get(i).getText()+"----"+BowlRuns.get(i).getText()+"----"+Wickets.get(i).getText()+"----"+Economy.get(i).getText();
	        	System.out.println(Concat1);
	        }
	 }
	 
}
