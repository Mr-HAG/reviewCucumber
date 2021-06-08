package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-html-reports",   //for reporting
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/", //for reading features
        glue = "com/vytrack/step_definitions", //for implementing in step defs
        dryRun = false,//for finding undefined methods
        tags = "@wip" //for running specific scenarios
)
public class CukesRunner {
}
