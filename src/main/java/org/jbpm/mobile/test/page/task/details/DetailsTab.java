package org.jbpm.mobile.test.page.task.details;

import org.jbpm.mobile.test.ElementPicker;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class DetailsTab {

    private final ElementPicker picker;

    private final WebElement descriptionField;
    private final WebElement statusField;
    private final WebElement dueOnField;
    private final WebElement priorityField;
    private final WebElement userField;

    private final WebElement processInstanceIdField;
    private final WebElement processDefinitionIdField;
    private final WebElement processInstanceDetailsButton;

    private final WebElement updateButton;

    public DetailsTab(ElementPicker picker) {
        this.picker = picker;

        descriptionField = picker.findFormTextareaByLabel("Description");
        statusField = picker.findFormInputByLabel("Status");
        dueOnField = picker.findFormInputByLabel("Due On");
        priorityField = picker.findFormInputByLabel("Priority");
        userField = picker.findFormInputByLabel("User");

        processInstanceIdField = picker.findFormInputByLabel("Process Instance Id");
        processDefinitionIdField = picker.findFormInputByLabel("Process Definition Id");
        processInstanceDetailsButton = picker.findFormElementByLabel("Process Instance Details");

        updateButton = picker.findElementByText("div", "Update");
    }

    public void fillInDescriptionField(String text) {
        descriptionField.sendKeys(text);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

}
