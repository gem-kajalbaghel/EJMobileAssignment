package com.gemini.mobile.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features" , glue = "com/gemini/mobile/stepdefinition",
        tags = "@Feature-Regression"
)

public class TestRunner
{

}
