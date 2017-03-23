package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
	    System.setProperty("webdriver.chrome.driver", "C:\\Ekta\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	WebElement gmail =driver.findElement(By.linkText("Gmail"));
		//click();
		//.sendKeys(Keys.CONTROL +"t");
		Actions action =new Actions(driver);
	//	action.keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Gmail"))).keyUp(Keys.SHIFT).build().perform();

		//WebDriverWait wait = new WebDriverWait(driver,5);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e =driver.findElement(By.id("lst-ib"));
		//driver.findElement(By.id("lst-ib")).sendKeys("Ekta");
		action.sendKeys(driver.findElement(By.id("lst-ib")), "tcs").build().perform();
		//  action.moveToElement(gmail).keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(gmail).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
//    Alert alert=driver.switchTo().alert();
    
	}

}
