package org.jbpm.mobile.test.suite.task;

import org.jbpm.mobile.test.page.task.NewTaskPage;
import org.jbpm.mobile.test.page.task.TaskDetailsPage;
import org.jbpm.mobile.test.page.task.details.WorkTab;
import org.jbpm.mobile.test.suite.MobileTestBase;
import org.junit.Test;

/**
 *
 * @author livthomas
 */
public class TaskProgressTest extends MobileTestBase {

    @Test
    public void testTaskProgress() {
        String taskName = Double.toHexString(Math.random());

        // create new task and go to details
        NewTaskPage ntp = homePage.goToTasksList().goToNewTask();
        ntp.fillInTaskNameField(taskName);
        TaskDetailsPage tdp = ntp.clickAddButton().goToDetails(taskName);
        WorkTab workTab = tdp.switchToWorkTab();

        workTab.clickReleaseButton();
        workTab.clickClaimButton();
        workTab.clickStartButton();
        workTab.clickCompleteButton();
    }

}
