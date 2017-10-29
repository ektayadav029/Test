package com.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import java.io.File;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class calBMITestXLS {

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
		Object[][] objArray = getTableArray("/Users/EktaYadav/Documents/workspace/SeleniumTraining/data/bmicalc.xls","BmiNew","anchor1");
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
	            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	            Sheet sheet = workbook.getSheet(sheetName);
	            Cell tableStart=sheet.findCell(tableName);
	            
	            int startRow,startCol, endRow, endCol,ci,cj;
	            
	            startRow=tableStart.getRow();
	            startCol=tableStart.getColumn();

	            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1,100, 64000,false);                

	            endRow=tableEnd.getRow();
	            endCol=tableEnd.getColumn();
	            
	            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
	                    "startCol="+startCol+", endCol="+endCol);
	            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
	            ci=0;

	            for (int i=startRow+1;i<endRow;i++,ci++){
	                cj=0;
	                for (int j=startCol+1;j<endCol;j++,cj++){
	                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
	                }
	            }
	        }
	        catch (Exception e)    {
	            System.out.println("error in getTableArray()");
	            
	        }
	        return(tabArray);
	    }
	
	

}
