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
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//" + tag + "[@" + attributeName
                + "='" + attributeValue + "']")));
    }

    public WebElement findElementByClass(String tag, String className) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(tag + "." + className)));
    }

    public WebElement findElementByText(String tag, String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//" + tag + "[contains(text(),'"
                + text + "')]")));
    }

    public List<WebElement> findElementsByHierarchy(String... tags) {
        StringBuilder sb = new StringBuilder("/");
        for (String tag : tags) {
            sb.append("/");
            sb.append(tag);
        }
        return driver.findElements(By.xpath(sb.toString()));
    }

    public WebElement findInputByLabel(String label) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/div[contains(div/text(), '"
                + label + "')]/div/div/input")));
    }

}
