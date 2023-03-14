package week4.day1.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/week4/day1/cucumber/feature/getIncidentsQPMultiple.feature",
				 glue="week4.day1.cucumber.stepDefititon"
					)

public class TestRunner extends AbstractTestNGCucumberTests{

}
