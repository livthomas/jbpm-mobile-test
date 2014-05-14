package org.jbpm.mobile.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class LoginPage {

    private final WebElement userNameField;
    private final WebElement passwordField;
    private final WebElement signInButton;

    public LoginPage(WebDriver driver) {
        userNameField = driver.findElement(By.xpath("//input[@name='j_username']"));
        passwordField = driver.findElement(By.xpath("//input[@name='j_password']"));
        signInButton = driver.findElement(By.cssSelector("input.button"));
    }

    public WebElement getUserNameInput() {
        return userNameField;
    }

    public WebElement getPasswordInput() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void signIn(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        signInButton.click();
    }

}
