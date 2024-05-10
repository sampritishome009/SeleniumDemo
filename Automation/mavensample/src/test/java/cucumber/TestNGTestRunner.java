package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->TestNG ,junit runner
@CucumberOptions(features="src/test/java/cucumber",glue="rahulshettyacademy.StepDefinitions",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
	
}
