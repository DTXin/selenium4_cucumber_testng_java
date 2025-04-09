package org.example.base;

import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

public abstract class BasePage {
    protected static final Logger logger = LogManager.getLogger();

    public void navigateToUrl() {
        var url = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("url");

        logger.info("Navigate to url `{}`", url);
        DriverManager.getDriver().navigate().to(url);
    }

    /********************************************************************
     ** Start Blocks: Group action on Element (Ex: Click, Hover...) *****
     *******************************************************************/

    // Click to element
    public void clickToElement(WebElement element) {
        scrollToElement(element);

        logger.info("Click to element: `{}`", element);
        element.click();
    }

    // Click an element using javascript executor.
    public void clickToElement_ByJavaScript(WebElement element) {
        scrollToElement(element);

        logger.info("Click to element (by javascript): `{}`", element);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
    }

    // Get text of element by javascript
    public String getText_ByJavaScript(WebElement element) {
        logger.info("Get text of an element (by javascript): `{}`", element);

        var textOfElement = (String) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return arguments[0].value;", element);
        logger.info("Text of element is: `{}`", textOfElement);

        return textOfElement;
    }

    /********************************************************************
     ** Start Blocks: Scroll Page (Ex: Scroll top, bottom...) ***********
     *******************************************************************/

    // Scroll into view of the browser window
    public void scrollToElement(WebElement element) {
        logger.info("Scroll to element into view...: `{}`", element);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", element);
    }

    // Scroll to top in page
    public void scrollToTop() {
        logger.info("Scroll up to footer page...");
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("document.documentElement.scrollTop = 0;");
    }

    // Scroll to bottom in page
    public void scrollToBottom() {
        logger.info("Scroll down to footer page...");
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /********************************************************************
     ** Start Blocks: Convert xpath, css, id... to WebElement ***********
     * 
     ** @param1: String xpath or css or id ******************************
     ** @param2: String for formatting **********************************
     *******************************************************************/

    // Convert element from xpath which can not use @FindBy fo find
    public WebElement getElementByXpath(String xpath, String... arg) {
        WebElement webElement = null;

        try {
            logger.info("Convert xpath element to web element: xpath is `{}` ", xpath);
            webElement = DriverManager.getDriver().findElement(By.xpath(xpath));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return webElement;
    }

    // Convert list of element from xpath which can not use @FindBy fo find
    public List<WebElement> getElementsByXpath(String xpath, String... arg) {
        List<WebElement> listElement = new ArrayList<>();

        try {
            logger.info("Convert xpath of a list element to list webElement: xpath is `{}` ", xpath);
            listElement = DriverManager.getDriver().findElements(By.xpath(xpath));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return listElement;
    }

    // Convert element from css which can not use @FindBy
    public WebElement getElementByCss(String css, String... arg) {
        WebElement webElement = null;

        try {
            logger.info("Convert css element to web element: css is `{}` ", css);
            webElement = DriverManager.getDriver().findElement(By.cssSelector(css));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return webElement;
    }

    // Convert css of list element to list webElement which can not use @FindBy
    public List<WebElement> getElementsByCss(String css, String... arg) {
        List<WebElement> listElement = new ArrayList<>();

        try {
            logger.info("Convert css of a list element to list webElement: css is `{}` ", css);
            listElement = DriverManager.getDriver().findElements(By.cssSelector(css));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return listElement;
    }

}
