package com.FMCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features")
//@CucumberOptions(features = "features/InvalidLoginDDT.feature")
//@CucumberOptions(features = "features" glue = "com.FMCucmber", 
//					dryRun=false, 
//					plugin = {"pretty", "html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
