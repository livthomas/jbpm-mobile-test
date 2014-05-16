package org.jbpm.mobile.test.page.task;

import java.util.List;
import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class TasksListPage extends AbstractPage {

    private final List<WebElement> tasks;

    private final WebElement newTaskButton;

    public TasksListPage(ElementPicker picker) {
        super(picker);
        tasks = picker.findListItems();
        newTaskButton = picker.findHeaderButton("New task");
    }

    public List<WebElement> getTasks() {
        return tasks;
    }

    public WebElement getNewTaskButton() {
        return newTaskButton;
    }

    public TaskDetailsPage goToDetails(String taskName) {
        picker.findListItem(taskName).click();
        return new TaskDetailsPage(picker);
    }

    public TaskDetailsPage goToDetails(String taskId, String taskName) {
        picker.findListItem(taskId + " : " + taskName).click();
        return new TaskDetailsPage(picker);
    }

    public NewTaskPage goToNewTask() {
        newTaskButton.click();
        return new NewTaskPage(picker);
    }

    public boolean isPresentInList(String taskName) {
        for (WebElement row : tasks) {
            if (row.getText().contains(taskName)) {
                return true;
            }
        }
        return false;
    }

}
