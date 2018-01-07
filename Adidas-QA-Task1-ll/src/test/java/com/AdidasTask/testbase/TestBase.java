package com.AdidasTask.testbase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.AdidasTask.utils.TestProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;




public class TestBase {
	
	public ExtentHtmlReporter reporter; 
	public ExtentReports extent;
	public ExtentTest test;

	
	@BeforeClass
	public static void init(){
		
		
	}
	
		
	
	
	
}
