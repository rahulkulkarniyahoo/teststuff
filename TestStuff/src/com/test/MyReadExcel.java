package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyReadExcel {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException {
	// File excel = new File ("resources/SingleInvoice_65422.xlsx");
	String myFile = "resources/qry42308_V2.xlsx";
	String [][] myCatchData = null;
	int k = 0;
	myCatchData = processFile(myFile);
	 for (int m = 1; m < myCatchData.length; m++) { // 0 will read the header lines
		for (int j = 0; j < 9; j++) {
		    System.out.println("VALUE IN MAIN = {m}=" + m + " {j} = " + j + " and value = " + myCatchData[m][j]);
		}
	    }
	

    }

    private static String [][] processFile(String myFile) {
	String[][] myData = null;
	File excel = new File(myFile);
	FileInputStream fis;
	try {
	    fis = new FileInputStream(excel);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    //XSSFSheet ws = wb.getSheet("qry41817");
	    XSSFSheet ws = wb.getSheetAt(0);
	    int rowNum = ws.getLastRowNum() + 1;
	    int colNum = ws.getRow(0).getLastCellNum();
	    String[][] data 	= new String[rowNum][colNum];
	    		myData 	= new String[rowNum][9];
	    int k = 0;
	    for (int i = 0; i < rowNum; i++) {

		XSSFRow row = ws.getRow(i);
		System.out.println(
			"----------------------------------------NEW ROW ---------------------------------------- ");
		for (int j = 0; j < colNum; j++) {
		    String value;
		    XSSFCell cell = row.getCell(j, Row.RETURN_NULL_AND_BLANK); 	// To take care of blanks
		    if (cell == null) {						// To take care of blanks
			value = "";
		    } else {
			value = cell.toString();
		    }

		    data[i][j] = value;
		    if (j == 0) { // Order Id
			myData[k][0] = value;
		    }
		    if (j == 40) { // Primary Advertiser
			myData[k][1] = value;
		    }

		    if (j == 39) { // EXTERNAL PO NUMBER
			myData[k][2] = value;
		    }

		    if (j == 5) { // Product Name
			myData[k][3] = value;
		    }
		    if (j == 4) { // Line Item Name
			myData[k][4] = value;
		    }
		    if (j == 11) { // Start Date
			myData[k][5] = value;
		    }
		    if (j == 12) { // End Date
			myData[k][6] = value;
		    }
		    if (j == 37) { // Billing Period Start Date
			myData[k][7] = value;
		    }
		    if (j == 38) { // Billing Period End Date
			myData[k][8] = value;
		    }

		    System.out.println("the row = " + i + " colNum is " + j + ": the value is " + value);
		    // System.out.println ("the value is " + value);
		}
		k++;
	    }
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<Total Values in K = " + k + "<<<<<<<<<<<<<<");
	    for (int m = 1; m < k; m++) { // 0 will read the header lines
		for (int j = 0; j < 9; j++) {
		    System.out.println("FINAL value is {m}=" + m + " {j} = " + j + " and value = " + myData[m][j]);
		}
	    }
	  
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    // e.printStackTrace();
	    System.out.println("File(s) does not exist at the location");
	}
	
	return myData;
    }

}
