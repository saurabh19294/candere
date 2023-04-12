package jewellery.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		features="classpath:features",
		glue="jewellery.stepdefs",
		tags="",
				 plugin = {"pretty", // to generate reports
				            "html:target/html/htmlreport.html",
				            "json:target/json/file.json",
				            },
				 		monochrome=true,
				        publish=true,
				        dryRun=false // to tell whether to test run(true) or actual run(false)
				        
		)
public class candererunners {

}
