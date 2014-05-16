package org.jbpm.mobile.test.page.task;

import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.jbpm.mobile.test.page.task.details.WorkTab;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class TaskDetailsPage extends AbstractPage {

    private final WebElement workTabLink;
    private final WebElement detailsTabLink;
    private final WebElement assignmentsTabLink;

    public TaskDetailsPage(ElementPicker picker) {
        super(picker);
        workTabLink = picker.findElementByText("div", "Work");
        detailsTabLink = picker.findElementByText("div", "Details");
        assignmentsTabLink = picker.findElementByText("div", "Assignments");
    }

    public WorkTab switchToWorkTab() {
        workTabLink.click();
        return new WorkTab(picker);
    }

    public void switchToDetailsTab() {
        detailsTabLink.click();
    }

    public void switchToAssignmentsTab() {
        assignmentsTabLink.click();
    }

}
