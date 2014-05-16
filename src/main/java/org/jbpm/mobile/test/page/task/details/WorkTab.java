package org.jbpm.mobile.test.page.task.details;

import org.jbpm.mobile.test.ElementPicker;

/**
 *
 * @author livthomas
 */
public class WorkTab {

    private final ElementPicker picker;

    public WorkTab(ElementPicker picker) {
        this.picker = picker;
    }

    private void clickButton(String text) {
        picker.findButton(text).click();
        picker.confirmSuccessPopup();
    }

    public void clickSaveButton() {
        clickButton("Save");
    }

    public void clickReleaseButton() {
        clickButton("Release");
    }

    public void clickClaimButton() {
        clickButton("Claim");
    }

    public void clickStartButton() {
        clickButton("Start");
    }

    public void clickCompleteButton() {
        clickButton("Complete");
    }

}
