package com.testNG;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;


public class BMIPOPage extends LoadableComponent<BMIPOPage> {

	
	WebDriver driver;
	
	@FindBy (how = How.NAME, using = "heightCMS")
	public WebElement height;
		
	@FindBy (id= "weightKg")
	@CacheLookup
	public WebElement weight;
	
	@FindBy (id= "Calculate")
	@CacheLookup
	public WebElement calBMI;
	
	@FindBy (id= "bmi")
	@CacheLookup
	public WebElement bmi;
	
	@FindBy (id= "bmi_category")
	@CacheLookup
	public WebElement bmiCategory;
	private String title = "BMI Calculator";
	
	public BMIPOPage()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Ekta\\Selenium\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	PageFactory.initElements(driver, this); //this is used for object of this class

	}
    
	public void calculateBMI(String height1,String weight1)
	{		
		height.sendKeys(height1);	
		weight.sendKeys(weight1);
		calBMI.click();
	}
	
	
	public String getBMI()
	{
		return bmi.getAttribute("value");		
	}
	
	
	public String getBMICategory()
	{
		return bmiCategory.getAttribute("value");				
	}

	@Override
	public void isLoaded(){
		assertTrue(driver.getTitle().equals(title));

	}

	@Override
	public void load() {
		driver.get("http://cookbook.seleniumacademy.com/mobilebmicalculator.html");

	}	
	
	
 }
