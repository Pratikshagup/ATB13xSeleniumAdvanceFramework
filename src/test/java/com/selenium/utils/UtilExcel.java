package com.selenium.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class UtilExcel {

        static Workbook book;
        static Sheet sheet;
        public static String Sheet_name  = System.getProperty("user.dir")+"";
public static Object[][] getTestDataFromExcel(String Sheetname){
    Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for (int i=0;i<sheet.getLastRowNum();i++){
        for (int j=0 ;j<sheet.getRow(0).getFirstCellNum();j++){
            data[i][j] = sheet.getRow(i+1).getCell(j).toString();//skipping 1 row as its headers
        }
    }
    return data;
}



}
