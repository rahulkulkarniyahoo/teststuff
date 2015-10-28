package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyFiles {

	public static void main (String[] args){
		//File source = new File ("src/com/test/ThisisNewFile.txt");
		//File dest = new File ("src/com/resources/ThisIsNewFile2.txt");
		
		File source = new File ("//anl-adv-f01p-p.anl.dmgt.net/Talend-Core-D/Talend-Stage/Scratch/Corporate/OperativeOne/Archive/TestOP1File.xlsx");
		File dest = new File ("//anl-adv-f01p-p.anl.dmgt.net/Talend-Core-D/Talend-Stage/Scratch/Corporate/OperativeOne/Archive/TestOP1File_Windows.xlsx");
		try
		{
			FileUtils.copyFile(source, dest);
			System.out.println("Copied .. Done");
		} catch(IOException ie){
		 ie.printStackTrace();
		}

	}
}
