package org.jbpm.mobile.test.suite.task;

import org.jbpm.mobile.test.page.task.NewTaskPage;
import org.jbpm.mobile.test.page.task.TaskDetailsPage;
import org.jbpm.mobile.test.page.task.details.AssignmentsTab;
import org.jbpm.mobile.test.suite.MobileTestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author livthomas
 */
public class TaskDelegationTest extends MobileTestBase {

    private static final String OTHER_USER = "otheruser";

    @Test
    public void testDelegateTaskToOtherUser() {
        String taskName = Double.toHexString(Math.random());

        // create new task and go to details
        NewTaskPage ntp = homePage.goToTasksList().goToNewTask();
        ntp.fillInTaskNameField(taskName);
        TaskDetailsPage tdp = ntp.clickAddButton().goToDetails(taskName);
        AssignmentsTab assignmentsTab = tdp.switchToAssignmentsTab();

        assignmentsTab.fillInUserOrGroupField(OTHER_USER);
        assignmentsTab.clickDelegateButton();

        Assert.assertTrue("Other user is list of potential owners!", assignmentsTab.getPotentialOwnersLabel().getText()
                .contains(OTHER_USER));
    }

}
