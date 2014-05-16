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

    private final static String TASK_NAME = "Special Ad-hoc Task";

    @Test
    public void testAddingNewAdhocTask() {
        NewTaskPage ntp = homePage.goToTasksList().goToNewTask();
        ntp.fillInTaskNameField(TASK_NAME);
        TasksListPage tlp = ntp.clickAddButton();
        Assert.assertTrue("New task is not present in the tasks list!", tlp.isPresentInList(TASK_NAME));
    }

}
