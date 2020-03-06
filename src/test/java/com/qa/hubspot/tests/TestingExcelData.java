package com.qa.hubspot.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingExcelData {
	/**
	 * This method is used to take the data from excel sheet
	 * 
	 * @throws Exception
	 */

	@Test(enabled=false)
	public void getData() throws Exception {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\LENOVO PC\\workspace\\Webservice-Framework\\src\\main\\java\\com\\qa\\hubspot\\testdata\\HubSpotTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("testdata");
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				System.out.println(sheet.getRow(i + 1).getCell(j).toString());
			}
		}
	}
	
	@Test(enabled=true)
	public void inputData() throws Exception{
		
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO PC\\workspace\\Webservice-Framework\\src\\main\\java\\com\\qa\\hubspot\\testdata\\HubSpotTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("testdata");
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				System.out.println(sheet.getRow(i+1).getCell(j).toString());
				
			}
		}
		
				
	}
}
