package org.example.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Reporter;

public class Hooks {

    @Before
    public void initDriver() throws MalformedURLException, URISyntaxException {
        var browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        var runMode = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("runMode");
        var platformName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformName");

        if (runMode.equalsIgnoreCase("grid")) {
            DriverManager.createRemoteDriver(browser.toLowerCase(), platformName);
        } else {
            DriverManager.createLocalDriver(browser.toLowerCase());
        }

        PageManager.getInstance();
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
        PageManager.cleanUp();
    }
}
