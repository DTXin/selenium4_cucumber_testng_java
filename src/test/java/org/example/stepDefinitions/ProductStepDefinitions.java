package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import org.example.base.PageManager;

public class ProductStepDefinitions {

    @Then("User is navigated to Product Page")
    public void userIsNavigatedToProductPage() {
        PageManager.getPageManager().getProductPage().verifyProductPageIsDisplayed();
    }
}
