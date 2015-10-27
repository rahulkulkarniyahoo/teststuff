package com.test;

public class Substrings {
	public static void main(String[] args) {
		
		String testString = "What is [1234567]";
		
		System.out.println("");
		System.out.println(testString.indexOf("]"));
		System.out.println(testString.substring(testString.indexOf("[") + 1, testString.lastIndexOf("]")));
		
	}
}
