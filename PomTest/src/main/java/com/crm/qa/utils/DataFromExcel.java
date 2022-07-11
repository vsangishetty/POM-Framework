package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel {
	
	//public static String TESTDATA_SHEET_PATH = "D:\\JavaProjects\\PomTest\\src\\main\\java\\com\\crm\\qa\\Testdata\\TestData.xlsx";

	public static Workbook book;
	public static Sheet sheet;
	
	public static void main(String[] args) {
		
		
			FileInputStream file = null;
			
			try {
			 file = new FileInputStream("D:\\JavaProjects\\PomTest\\src\\main\\java\\com\\crm\\qa\\Testdata\\TestData.xlsx");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet("contacts");
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			 System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					 System.out.println(data[i][k]);
				}
			}
			//return data;
		}

	}


