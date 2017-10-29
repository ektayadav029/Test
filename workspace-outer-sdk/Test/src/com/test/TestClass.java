/**
 * 
 */
package com.test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author 735084
 *
 */
public class TestClass {

	public static void main(String [] args) throws InterruptedException {

		// Set chrome driver properties	
		System.setProperty("webdriver.chrome.driver", "C:\\Ekta\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	 
		driver.get(TestData.launchUrl);
	    String ActualScreenName = driver.getTitle();
		System.out.println(ActualScreenName + " " +"is launched");
		
		      Thread.sleep(2000);	   
//		      driver.findElement(By.id("USER")).click();
//		      Thread.sleep(2000);
		      
		      driver.findElement(By.id("USER")).sendKeys(TestData.employeeId);
		      Thread.sleep(2000);
		      
//		      driver.findElement(By.id("PASSWORD")).click();
//		      Thread.sleep(2000);
		    
		      driver.findElement(By.id("PASSWORD")).sendKeys(TestData.employeePassword);
		      driver.findElement(By.id("login_button")).submit();
		      String ActualHomeScreenName = driver.getTitle();
		       System.out.println("ActualHomeScreenName is" + ActualHomeScreenName );
		      
		      if(ActualHomeScreenName.equals(TestData.HomeScreenTitle))
		      {
		    	  System.out.println("Login Successfully");
		   
		      }
		      else 
		    	  
		      {
		    	  System.out.println("Login Failed");
		      }
		     	      
		      Thread.sleep(2000);
		      driver.findElement(By.id("uam_modal")).click();
		      Thread.sleep(2000);
	          driver.findElement(By.id("logoutbutton")).submit();
		      Thread.sleep(2000);
	      System.out.println("Logout Successful");	      
	      
	      
	}
				
	}
