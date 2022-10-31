package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\PragatiSharma\\IdeaProjects\\Assingment27october\\src\\test\\java\\FeatureFile\\DataTable.feature"},
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty", "json:Report/Cucumber.json", "junit:Report/XMLReport.xml",
                "html:Report/cucumberReport"}
)
class Runner1 {
}
