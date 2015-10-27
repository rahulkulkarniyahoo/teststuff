package com.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZooTest {

		WebDriver driver;
		
		@Before
		public void setUp(){
			System.out.println("Came in Setup");
			driver = new FirefoxDriver();
			driver.navigate().to("http://thetestroom.com/webapp/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@After
		public void tearDown(){
			System.out.println("Goodbye!");
			driver.close();
		}
		
		@Test
		public void seeTitleHomePage(){
			System.out.println("Came in seeTitleHomePage");
			Assert.assertTrue(driver.getTitle().contains("Home"));
			System.out.println("If you see this console message, Title is Home");
		}
		
		@Test
		public void seeTitleAdoption(){
			driver.findElement(By.id("adoption_link")).click();
			Assert.assertTrue(driver.getTitle().contains("Ugly"));
			System.out.println("If you see this console message, Title is Adoption");
		}
	
		@Rule
		public TestRule listen = new TestWatcher(){
			
			@Override
			public void failed (Throwable t, Description description){
				System.out.println("Test Failed !");
				System.out.println("***************" + description.getClassName() + "," + description.getMethodName());
				takeScreenShot(description.getClassName() + "-"+ description.getMethodName());
			}
		};
		
		public void takeScreenShot(String name) {
			System.out.println("Name of the file = " + name);
			//File dest = new File ("/src/ouch/ThisIsNewFile.png");
			System.out.println("Before taking screenshot");
			System.out.println("Title of current page = " + driver.getTitle());			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			System.out.println("After taking screenshot and now copying files");
			
			
			//File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File ("src/com/resources/" + name + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Screenshot completed !!");
		}
}
