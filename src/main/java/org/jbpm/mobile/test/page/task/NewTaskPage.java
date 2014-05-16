package org.jbpm.mobile.test.page.task;

import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class NewTaskPage extends AbstractPage {

    private final WebElement taskNameField;

    private final WebElement addButton;

    public NewTaskPage(ElementPicker picker) {
        super(picker);
        taskNameField = picker.findFormInputByLabel("Task Name");
        addButton = picker.findButton("Add");
    }

    public WebElement getTaskNameField() {
        return taskNameField;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public void fillInTaskNameField(String taskName) {
        taskNameField.sendKeys(taskName);
    }

    public TasksListPage clickAddButton() {
        addButton.click();
        return new TasksListPage(picker);
    }

}
