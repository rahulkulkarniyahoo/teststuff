package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyFiles {

	public static void main (String[] args){
		File source = new File ("src/com/test/ThisisNewFile.txt");
		//File dest = new File ("src/com/resources/ThisIsNewFile2.txt");
		
		File dest = new File ("//Talend-Core-D//Talend-Stage//Scratch//ThisIsNewFile2.txt");
		try{
			
			FileUtils.copyFile(source, dest);
		} catch(IOException ie){
		 ie.printStackTrace();
		}
	}
}
