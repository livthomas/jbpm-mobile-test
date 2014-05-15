package org.jbpm.mobile.test.page;

import org.jbpm.mobile.test.ElementPicker;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class LoginPage {

    private final WebElement userNameField;
    private final WebElement passwordField;
    private final WebElement signInButton;

    public LoginPage(ElementPicker picker) {
        userNameField = picker.findElementByAttribute("input", "name", "j_username");
        passwordField = picker.findElementByAttribute("input", "name", "j_password");
        signInButton = picker.findElementByClass("input", "button");
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
