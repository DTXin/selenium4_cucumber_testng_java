package org.example.pageObjects.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger();

    public void inputTextToUsername(String text) {
        WebElement username = getElementByCss(LoginPageLocators.USERNAME_CSS);

        logger.info("User input text `{}` to username field", text);
        username.sendKeys(text);
    }

    public void inputTextToPassword(String text) {
        WebElement password = getElementByCss(LoginPageLocators.PASSWORD_CSS);

        logger.info("User input text `{}` to password field", text);
        password.sendKeys(text);
    }

    public void clickOnLoginButton() {
        WebElement loginButton = getElementByCss(LoginPageLocators.LOGIN_BUTTON_CSS);

        logger.info("User click on login button");
        loginButton.click();
    }

    public void verify_ErrorContainer_IsDisplayed() {
        WebElement errorContainer = getElementByCss(LoginPageLocators.ERROR_CONTAINER_CSS);

        logger.info("Verify error container is displayed.");
        Assert.assertTrue(errorContainer.isDisplayed());
    }

    public void verify_ErrorMessage(String expectedMessage) {
        WebElement actualMessage = getElementByCss(LoginPageLocators.ERROR_MESSAGE_CSS);

        logger.info("Verify error message is displayed");
        logger.info("Actual of error message: `{}`", actualMessage);
        logger.info("Expected of error message: `{}`", expectedMessage);
        Assert.assertEquals(actualMessage.getText(), expectedMessage);
    }
}
