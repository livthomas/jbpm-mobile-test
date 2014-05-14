package org.jbpm.mobile.test.suite;

import org.jbpm.mobile.test.page.process.DefinitionsListPage;
import org.jbpm.mobile.test.page.process.InstancesListPage;
import org.jbpm.mobile.test.page.task.TasksListPage;
import org.junit.Test;

/**
 *
 * @author livthomas
 */
public class BasicTest extends MobileTestBase {

    @Test
    public void testAccessToSections() {
        DefinitionsListPage processDefinitions = homePage.goToProcessDefinitions();
        processDefinitions.goBack();

        InstancesListPage processInstances = homePage.goToProcessInstances();
        processInstances.goBack();

        TasksListPage tasksList = homePage.goToTasksList();
        tasksList.goBack();
    }

}
