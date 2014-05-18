package org.jbpm.mobile.test.suite;

import org.junit.Test;

/**
 *
 * @author livthomas
 */
public class BasicTest extends MobileTestBase {

    @Test
    public void testAccessToSections() {
        homePage.goToProcessDefinitions().goBack().goToProcessInstances().goBack().goToTasksList().goBack();
    }

}
