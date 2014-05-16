package org.jbpm.mobile.test.suite.task;

import org.jbpm.mobile.test.page.task.NewTaskPage;
import org.jbpm.mobile.test.page.task.TasksListPage;
import org.jbpm.mobile.test.suite.MobileTestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author livthomas
 */
public class NewTaskTest extends MobileTestBase {

    @Test
    public void testAddingNewAdhocTask() {
        String taskName = Double.toHexString(Math.random());
        NewTaskPage ntp = homePage.goToTasksList().goToNewTask();
        ntp.fillInTaskNameField(taskName);
        TasksListPage tlp = ntp.clickAddButton();
        Assert.assertTrue("New task is not present in the tasks list!", tlp.isPresentInList(taskName));
    }

}
