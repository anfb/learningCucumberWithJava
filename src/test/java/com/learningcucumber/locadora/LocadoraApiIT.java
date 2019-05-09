package com.learningcucumber.locadora;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/com/learningcucumber/junitexample/locadora.feature",
					plugin ="pretty",
					monochrome = true,
					snippets = SnippetType.CAMELCASE,
					dryRun = false,
					strict = false )
public class LocadoraApiIT { 
	 
}
