package com.testNG;
/*
 * This Test is written for reading data from xlsx (using poi) in TestNG
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import org.testng.annotations.DataProvider;

public class calBMITestXLSX {

	 BMIPOPage pageObject;

	@BeforeMethod
	public  void setUpBeforeClass() throws Exception {
 
    pageObject = new BMIPOPage();  
    pageObject.get();
	}
 
	@AfterMethod
	public void tearDownAfterClass() throws Exception {
		
	}
	
	@DataProvider (name ="inputData")
	public Object[][] testData(){

		Object[][] objArray = getTableArray("C:\\Ekta\\Selenium\\new\\bmi_excel.xlsx","BmiNew","anchor1");
		return objArray;
	}

	@Test(dataProvider ="inputData")
	public void testP(String height ,String weight,String bmi ,String bmiCategory) {
		
	  //fail("Not yet implemented");
	  pageObject.calculateBMI(height,weight);
      AssertJUnit.assertEquals(bmi,pageObject.getBMI());
      AssertJUnit.assertEquals(bmiCategory,pageObject.getBMICategory());
	}
	
	
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
	        String[][] tabArray=null;
 try{

	FileInputStream fis=new FileInputStream(xlFilePath);
	///Users/EktaYadav/Documents/workspace/SeleniumTraining/data/bmi_excel.xlsx
	
	  XSSFWorkbook book = new XSSFWorkbook(fis);
	  XSSFSheet sheet=book.getSheet(sheetName); 
	  
	  int rowCount= sheet.getLastRowNum()-sheet.getFirstRowNum();
	  System.out.println( "row" + rowCount);
       
	  int colCount =sheet.getRow(1).getLastCellNum();
	  System.out.println(   "col" + sheet.getRow(0).getLastCellNum());
	    tabArray = new String[rowCount][colCount-1];
	   
     for (int i=1;i<=rowCount;i++)
	  {
		Row row=sheet.getRow(i);
		
		for(int j=0;j<colCount-1;j++)
		{
			Cell cell=row.getCell(j);
			
			System.out.println( "cell number" + j);
			String value =cell.getStringCellValue();
			
			System.out.println( "value" + value);
			tabArray[i][j]=value;
		}
		   System.out.println("Populating Array");
	 } 
	   
	 }	        	        
	       catch (Exception e)    {
	            System.out.println("error in getTableArray()");
	            e.printStackTrace();            
	       }
			return tabArray;
	    }
	
	

}
