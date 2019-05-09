package com.learningcucumber.junitexample.contador;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/com/learningcucumber/junitexample/contador.feature",
				plugin = "pretty",
				monochrome = true,
				dryRun = false,
				snippets = SnippetType.CAMELCASE, 
				strict = true)
public class contadorApiIT {

}
