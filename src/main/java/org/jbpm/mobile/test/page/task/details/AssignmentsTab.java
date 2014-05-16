package org.jbpm.mobile.test.page.task.details;

import org.jbpm.mobile.test.ElementPicker;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class AssignmentsTab {

    private final ElementPicker picker;

    private final WebElement potentialOwnersLabel;
    private final WebElement userOrGroupField;

    public AssignmentsTab(ElementPicker picker) {
        this.picker = picker;

        potentialOwnersLabel = picker.findFormElementByLabel("Potential Owners");
        userOrGroupField = picker.findFormInputByLabel("User or Group");
    }

    public WebElement getPotentialOwnersLabel() {
        return potentialOwnersLabel;
    }

    public WebElement getUserOrGroupField() {
        return userOrGroupField;
    }

    public WebElement getDelegateButton() {
        return picker.findButton("Delegate");
    }

    public void fillInUserOrGroupField(String text) {
        userOrGroupField.sendKeys(text);
    }

    public void clickDelegateButton() {
        getDelegateButton().click();
        picker.confirmSuccessPopup();
    }

}
