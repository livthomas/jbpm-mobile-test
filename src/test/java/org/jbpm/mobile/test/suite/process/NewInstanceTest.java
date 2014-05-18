package org.jbpm.mobile.test.suite.process;

import junit.framework.Assert;
import org.jbpm.mobile.test.page.process.DefinitionDetailsPage;
import org.jbpm.mobile.test.page.process.InstancesListPage;
import org.jbpm.mobile.test.suite.MobileTestBase;
import org.junit.Test;

public class NewInstanceTest extends MobileTestBase {

    public static final String EVALUATION_NAME = "Evaluation";
    public static final String EVALUATION_VERSION = "1";

    @Test
    public void testCreateNewProcessInstance() {
        DefinitionDetailsPage pddp = homePage.goToProcessDefinitions().goToDetails(EVALUATION_NAME, EVALUATION_VERSION);
        pddp.clickNewInstanceButton();
        InstancesListPage pilp = pddp.goToProcessInstances();
        Assert.assertTrue("Process " + EVALUATION_NAME + " is not present in the instances list",
                pilp.isPresentInList(EVALUATION_NAME));
    }

}
