import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class tripHobo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
	    System.setProperty("webdriver.chrome.driver", "C:\\Ekta\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.triphobo.com/");
		driver.findElement(By.id("spl-autocomplete-search")).sendKeys(Keys.chord("Pu"));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
		
		
	  //  List<WebElement> e= driver.findElements(By.className());
		Actions act = new Actions(driver);
	//	act.moveToElement(e).click();
		
      //WebElement gmail =driver.findElement(By.linkText("Gmail"));
	
	
	}

}
