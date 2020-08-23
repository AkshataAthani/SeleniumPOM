package com.sf.qa.util;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	@SuppressWarnings("static-access")
	public String[][] getCellData(String path, String sheet) throws InvalidFormatException, IOException {
	
		//First solution to read data (.xlsx and .xls)
		FileInputStream stream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(stream);
		Sheet s = workbook.getSheet(sheet);

		/*
		 * //Second solution to read data (.xlsx)
		 * 
		 * XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new
		 * File(path)));
		 * 
		 * XSSFSheet s = workbook.getSheetAt(0);
		 */
		 
		int rowcount = s.getLastRowNum();
		int cellcount = s.getRow(0).getLastCellNum();
	
		String data[][] = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell c =  r.getCell(j);
				try {
					if ((c).getCellType() == (c).CELL_TYPE_STRING) {
						data[i - 1][j] = (c).getStringCellValue();
					} else if ((c).getCellType() == (c).CELL_TYPE_NUMERIC){
						data[i - 1][j] = String.valueOf((c).getNumericCellValue());
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
		return data;
	}


}






