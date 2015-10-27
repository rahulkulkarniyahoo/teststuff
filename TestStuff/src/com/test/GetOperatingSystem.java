package com.test;

public class GetOperatingSystem {

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Mac")){
			System.out.println("Hello Mac Operating System");
		}
		else if (System.getProperty("os.name").contains("Windows")){
			System.out.println("Hello Windodws Operating System");
			System.out.println("Dih!");
		}
	}

}
