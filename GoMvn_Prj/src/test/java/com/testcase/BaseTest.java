package com.testcase;

import java.util.Map;

import org.testng.annotations.Test;

import com.excel.DataFactory;

public class BaseTest {
	
	@Test(dataProvider="excelData",dataProviderClass=DataFactory.class)
	public void check(Map<String , String > testData) {
		System.out.println(testData.get("Name"));
		
		
	}
	
	

}
