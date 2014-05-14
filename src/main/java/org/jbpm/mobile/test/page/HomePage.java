package org.jbpm.mobile.test.page;

import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.process.DefinitionsListPage;
import org.jbpm.mobile.test.page.process.InstancesListPage;
import org.jbpm.mobile.test.page.task.TasksListPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class HomePage extends AbstractPage {

    private final WebElement processDefinitionsLink;
    private final WebElement processInstancesLink;
    private final WebElement tasksListLink;

    public HomePage(ElementPicker picker) {
        super(picker);

        processDefinitionsLink = picker.findElementByText("div", "Process Definitions");
        processInstancesLink = picker.findElementByText("div", "Process Instances");
        tasksListLink = picker.findElementByText("div", "Tasks List");
    }

    public DefinitionsListPage goToProcessDefinitions() {
        processDefinitionsLink.click();
        return new DefinitionsListPage(picker);
    }

    public InstancesListPage goToProcessInstances() {
        processInstancesLink.click();
        return new InstancesListPage(picker);
    }

    public TasksListPage goToTasksList() {
        tasksListLink.click();
        return new TasksListPage(picker);
    }

}
