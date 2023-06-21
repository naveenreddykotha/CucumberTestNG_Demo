package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features/LoginPage.feature"}, glue = {"com.example.stepdefinations"},
plugin = {})
public class TestRunner extends AbstractTestNGCucumberTests {

}
