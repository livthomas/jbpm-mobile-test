package org.jbpm.mobile.test.page.process;

import java.util.List;
import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.jbpm.mobile.test.page.HomePage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class InstancesListPage extends AbstractPage {

    private final List<WebElement> instances;

    public InstancesListPage(ElementPicker picker) {
        super(picker);
        instances = picker.findListItems();
    }

    public List<WebElement> getInstances() {
        return instances;
    }

    public InstanceDetailsPage goToDetails(String instanceId, String processId) {
        picker.findListItem(instanceId + " : " + processId).click();
        return new InstanceDetailsPage(picker);
    }

    public HomePage goBack() {
        clickBackButton();
        return new HomePage(picker);
    }

    public boolean isPresentInList(String processId) {
        for (WebElement row : instances) {
            if (row.getText().contains(processId)) {
                return true;
            }
        }
        return false;
    }

}
