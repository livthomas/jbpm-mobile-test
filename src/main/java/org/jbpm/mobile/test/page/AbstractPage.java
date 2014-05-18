package org.jbpm.mobile.test.page;

import org.jbpm.mobile.test.ElementPicker;
import org.openqa.selenium.WebElement;

/**
 *
 * @author livthomas
 */
public abstract class AbstractPage {

    protected final ElementPicker picker;

    public AbstractPage(ElementPicker picker) {
        this.picker = picker;
    }

    public WebElement getBackButton() {
        return picker.findHeaderButton("Back");
    }

    public void clickBackButton() {
        getBackButton().click();
    }

}
