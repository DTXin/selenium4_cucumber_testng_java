package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.base.PageManager;

public class LoginStepDefinitions {

    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        PageManager.getPageManager().getLoginPage().navigateToUrl();
    }

    @When("User enter valid username: {} and password: {}")
    public void userEnterValidAnd(String username, String password) {
        PageManager.getPageManager().getLoginPage().inputTextToUsername(username);
        PageManager.getPageManager().getLoginPage().inputTextToPassword(password);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        PageManager.getPageManager().getLoginPage().clickOnLoginButton();
    }

    @Then("Verify error container is displayed")
    public void verify_ErrorContainer_IsDisplayed() {
        PageManager.getPageManager().getLoginPage().verify_ErrorContainer_IsDisplayed();
    }

    @Then("Verify error message: {} is existed")
    public void verify_ErrorMessage(String expectedMessage) {
        PageManager.getPageManager().getLoginPage().verify_ErrorMessage(expectedMessage);
    }

}
