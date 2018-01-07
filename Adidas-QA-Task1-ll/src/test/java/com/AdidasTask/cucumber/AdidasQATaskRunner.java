package com.AdidasTask.cucumber;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.AdidasTask.utils.TestProperties;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/feature/" }, format = {
		"html:target/cucumber-html-reports" }, glue = { "classpath:com/AdidasTask/cucumber/steps" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:ExtentReport/report.html" }, strict = true)
public class AdidasQATaskRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("username", System.getProperty("user.name"));
		Reporter.setTestRunnerOutput("Adidas QA Task Test Report");
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
		Reporter.setSystemInfo("OS Ver", System.getProperty("os.version"));
		Reporter.setSystemInfo("URL",TestProperties.base_api);
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		
		
	}

}