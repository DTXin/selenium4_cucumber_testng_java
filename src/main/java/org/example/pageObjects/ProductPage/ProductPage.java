package org.example.pageObjects.ProductPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage extends BasePage {
    private static final Logger logger = LogManager.getLogger();

    public void verifyProductPageIsDisplayed() {
        WebElement app_logo = getElementByXpath(ProductPageLocators.APPLOGO_XPATH);

        logger.info("Verify product page is displayed (`{}`)", app_logo.isDisplayed());
        Assert.assertTrue(app_logo.isDisplayed(), "Product page is not displayed.");
    }
}
