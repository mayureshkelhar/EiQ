import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue={"StepDefinition"},
plugin = {"pretty","html:target"})
public class Runner
{

}