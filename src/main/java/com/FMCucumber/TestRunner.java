package com.FMCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@CucumberOptions(features = "features")
@CucumberOptions(features = "features/InvalidLoginDDT.feature")
public class TestRunner extends AbstractTestNGCucumberTests {

}
