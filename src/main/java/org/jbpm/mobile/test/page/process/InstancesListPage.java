package org.jbpm.mobile.test.page.process;

import java.util.List;
import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class InstancesListPage extends AbstractPage {

    private final List<WebElement> instances;

    public InstancesListPage(ElementPicker picker) {
        super(picker);
        instances = picker.findElementsByHierarchy("ul", "li", "div");
    }

    public List<WebElement> getInstances() {
        return instances;
    }

    public void goToDetails(String instanceId, String processId) {
        picker.findElementByText("ul/li/div", instanceId + " : " + processId).click();
    }

}
