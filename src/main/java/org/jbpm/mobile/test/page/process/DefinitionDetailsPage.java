package org.jbpm.mobile.test.page.process;

import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class DefinitionDetailsPage extends AbstractPage {

    private final WebElement newInstanceButton;
    private final WebElement viewProcessInstancesButton;

    public DefinitionDetailsPage(ElementPicker picker) {
        super(picker);
        newInstanceButton = picker.findButton("New Instance");
        viewProcessInstancesButton = picker.findButton("View Process Instances");
    }

    public WebElement getNewInstanceButton() {
        return newInstanceButton;
    }

    public WebElement getViewProcessInstancesButton() {
        return viewProcessInstancesButton;
    }

    public void clickNewInstanceButton() {
        newInstanceButton.click();
        picker.confirmSuccessPopup();
    }

    public InstancesListPage goToProcessInstances() {
        viewProcessInstancesButton.click();
        return new InstancesListPage(picker);
    }

    public DefinitionsListPage goBack() {
        clickBackButton();
        return new DefinitionsListPage(picker);
    }

}
