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
public class DefinitionsListPage extends AbstractPage {

    private final List<WebElement> definitions;

    public DefinitionsListPage(ElementPicker picker) {
        super(picker);
        definitions = picker.findListItems();
    }

    public List<WebElement> getDefinitions() {
        return definitions;
    }

    public DefinitionDetailsPage goToDetails(String processId, String version) {
        picker.findListItem(processId + " : " + version).click();
        return new DefinitionDetailsPage(picker);
    }

    public HomePage goBack() {
        clickBackButton();
        return new HomePage(picker);
    }

}
