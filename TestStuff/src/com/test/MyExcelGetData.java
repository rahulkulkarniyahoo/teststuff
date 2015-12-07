package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelGetData {

	  /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        File excel =  new File ("resources/SingleInvoice_65422.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //XSSFSheet ws = wb.getSheet("Input");
        XSSFSheet ws = wb.getSheet("My1");
        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        String [][] data = new String [rowNum] [colNum];
        String [][] myData = new String [rowNum] [colNum];
        
        for(int i = 0; i <rowNum; i++){
            XSSFRow row = ws.getRow(i);
            System.out.println ("----------------------------------------NEW ROW ---------------------------------------- ");
                for (int j = 0; j < colNum; j++){
                    XSSFCell cell = row.getCell(j);
                    String value = cell.toString();
                    data[i][j] = value;
                    System.out.println ("the colNum is " + j + ": the value is " + value);
                   // System.out.println ("the value is " + value);
                }
        }

    }

}
