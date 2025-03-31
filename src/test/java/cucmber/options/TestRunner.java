package cucmber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//use - src/test/java/features/newFeatureFilename in the 'features' - if you create and work on new feature file specifically 
//, tags = "@DeletePlace" - add the tags as per the requirement
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", 
			     glue={"stepdefinitions"},
			     plugin={"pretty", "html:target/htmlReports/cucumber-report.html", 
			    		           "json:target/jsonReports/cucumber-report.json"}

			     //,monochrome = true,
			     //publish = true
			     )
public class TestRunner {

}
