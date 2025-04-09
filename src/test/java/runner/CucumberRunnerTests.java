package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//@CucumberOptions(
//        features = "src/test/java/org/example/features",
//        glue = {
//                "org.example.stepDefinitions",
//                "org.example.base"
//        },
//        plugin = {
//                "pretty",
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//        })

@Test
@CucumberOptions(plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
