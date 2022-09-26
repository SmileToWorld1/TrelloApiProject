package trello.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/trello_api_features",
        glue = "trello/step_definitions",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {
}
