package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataFactory {
	
	@DataProvider(name="excelData")
	public Object[][] reader() throws FileNotFoundException,IOException{
		
		File file = new File("C:\\Users\\Anupam\\Desktop\\NeverSettle\\GoMvn_Prj\\src\\test\\resources\\com\\accessexcel\\AccessExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		DataFormatter formatter = new DataFormatter();
		
		XSSFSheet sheet = workbook.getSheet("Base");
		
		int rowCount = sheet.getLastRowNum();
		
		XSSFRow headerRow = sheet.getRow(0);
		
		int colCount = headerRow.getLastCellNum();
		
		Map<String , String > dataMap = new HashMap<String, String>();
		List<Map<String, String>> testDataList = new ArrayList<Map<String, String>>() ;
		
		for(int i=0; i<=rowCount; i++) {
			
			XSSFRow dataRow = sheet.getRow(i+1);
			
			for(int j=0;j<colCount;j++) {
				
				String key = formatter.formatCellValue(headerRow.getCell(j));
				
				String value = formatter.formatCellValue(dataRow.getCell(j));
				
				
				dataMap.put(key, value);
			}
			
			testDataList.add(dataMap);
			
			
		}
		
		Object[][] obj = new Object[testDataList.size()][1]; 
		
		for(int i =0;i<testDataList.size();i++ ) {
			obj[i][0] = testDataList.get(i);
		}
		
		
		return obj;
		
	}
	

}
