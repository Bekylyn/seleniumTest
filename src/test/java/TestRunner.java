import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/testamplify.feature",
        glue =  {"stepDefinitions"},
        plugin = {"pretty", "summary"},
        monochrome = false
)
public class TestRunner { }

