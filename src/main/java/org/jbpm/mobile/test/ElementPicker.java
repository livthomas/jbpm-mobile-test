package org.jbpm.mobile.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author livthomas
 */
public class ElementPicker {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public ElementPicker(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement findElementByAttribute(String tag, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//" + tag + "[@" + attributeName + "='" + attributeValue + "']")));
    }

    public WebElement findElementByClass(String tag, String className) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//" + tag + "[contains(@class,'" + className + "')]")));
    }

    public WebElement findElementByText(String tag, String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//" + tag + "[contains(text(),'" + text + "')]")));
    }

    public WebElement findButton(String text) {
        return findElementByText("div", text);
    }

    public WebElement findHeaderButton(String text) {
        return findElementByText("p", text);
    }

    public List<WebElement> findListItems() {
        return driver.findElements(By.xpath("//ul/li/div"));
    }

    public WebElement findListItem(String text) {
        return findElementByText("ul/li/div", text);
    }

    public WebElement findFormElementByLabel(String tag, String label) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li/div[contains(div/text(), '" + label + "')]/div/" + tag)));
    }

    public WebElement findFormInputByLabel(String label) {
        return findFormElementByLabel("div/input", label);
    }

    public WebElement findFormTextareaByLabel(String label) {
        return findFormElementByLabel("div/textarea", label);
    }

    public WebElement findFormButtonByLabel(String label) {
        return findFormElementByLabel("div", label);
    }

    public void confirmSuccessPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(div/text(),'Success')]/div/div[contains(text(),'Ok')]"))).click();
    }

}
