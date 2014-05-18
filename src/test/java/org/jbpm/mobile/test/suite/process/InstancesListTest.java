package org.jbpm.mobile.test.suite.process;

import java.util.List;
import junit.framework.Assert;
import org.jbpm.mobile.test.page.process.DefinitionDetailsPage;
import org.jbpm.mobile.test.page.process.InstancesListPage;
import org.jbpm.mobile.test.suite.MobileTestBase;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class InstancesListTest extends MobileTestBase {

    public static final String EVALUATION_NAME = "Evaluation";
    public static final String EVALUATION_VERSION = "1";

    public static final String HIRING_NAME = "Hiring a Developer";
    public static final String HIRING_VERSION = "1";

    @Test
    public void testInstancesListForGivenDefinition() {
        DefinitionDetailsPage pddp = homePage.goToProcessDefinitions().goToDetails(EVALUATION_NAME, EVALUATION_VERSION);
        pddp.clickNewInstanceButton();

        InstancesListPage pilp = pddp.goBack().goBack().goToProcessInstances();
        Assert.assertTrue("Process " + EVALUATION_NAME + " is not present in the instances list",
                pilp.isPresentInList(EVALUATION_NAME));

        pddp = pilp.goBack().goToProcessDefinitions().goToDetails(HIRING_NAME, HIRING_VERSION);
        pddp.clickNewInstanceButton();

        List<WebElement> hiringInstances = pddp.goToProcessInstances().getInstances();
        for (WebElement instance : hiringInstances) {
            if (instance.getText().contains(EVALUATION_NAME)) {
                Assert.fail("Process instances list contains also " + EVALUATION_NAME + " process!");
            }
        }
    }

}
