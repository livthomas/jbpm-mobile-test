package org.jbpm.mobile.test.page.process;

import java.util.List;
import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.AbstractPage;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public class DefinitionsListPage extends AbstractPage {

    private final List<WebElement> definitions;

    public DefinitionsListPage(ElementPicker picker) {
        super(picker);
        definitions = picker.findElementsByHierarchy("ul", "li", "div");
    }

    public List<WebElement> getDefinitions() {
        return definitions;
    }

    public void goToDetails(String processId, String version) {
        picker.findElementByText("ul/li/div", processId + " : " + version).click();
    }

}
