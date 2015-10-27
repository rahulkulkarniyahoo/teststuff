package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyFiles {

	public static void main (String[] args){
		File source = new File ("src/com/resources/abc.txt");
		File dest = new File ("src/com/resources/ThisIsNewFile.png");
		
		
		try{
			
			FileUtils.copyFile(source, dest);
		} catch(IOException ie){
		 ie.printStackTrace();
		}
	}
}
