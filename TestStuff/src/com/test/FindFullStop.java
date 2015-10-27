package com.test;

public class FindFullStop {

	public static void main(String[] args) {
		
		String a = "Hello.";
		
		System.out.println("Last Character = " + a.substring(a.length()-1));
	    System.out.println("W/O lasts character = " + a.substring(0,a.length() -1));
	}

}
