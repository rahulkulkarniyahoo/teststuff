package com.test;

public class PropertiesCheck {

	public static void main(String[] args) {
		String someString = "How are you";
		System.out.println("user dir :" + System.getProperty("user.dir"));
		System.out.println("user dir :" + System.getProperty("user.home"));
		
		System.out.println(someString.replace(" ", ""));
	}

}
