package org.jbpm.mobile.test.suite;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;
import org.jbpm.mobile.test.ElementPicker;
import org.jbpm.mobile.test.page.HomePage;
import org.jbpm.mobile.test.page.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author livthomas
 */
public abstract class MobileTestBase {

    private SelendroidLauncher selendroidServer;

    protected WebDriver driver;

    private static final String IP_ADDRESS = "147.251.236.6";
    private static final String APP_URL = "http://" + IP_ADDRESS + ":8080/jbpm-console-ng-jboss-as7.0/"
            + "org.jbpm.console.ng.jBPMShowcase/jBPM.html?standalone=true&perspective=MobilePresenter";

    private static final String USERNAME = "johndoe";
    private static final String PASSWORD = "johnie1234;";

    protected HomePage homePage;

    @Before
    public void startSelendroidServer() throws Exception {
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
        SelendroidConfiguration config = new SelendroidConfiguration();

        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.lauchSelendroid();

        DesiredCapabilities caps = SelendroidCapabilities.android();

        driver = new SelendroidDriver(caps);

        driver.get(APP_URL);

        ElementPicker picker = new ElementPicker(driver);

        new LoginPage(picker).signIn(USERNAME, PASSWORD);

        // wait while loading page
        picker.findElementByText("div", "jBPM Mobile");

        homePage = new HomePage(picker);
    }

    @After
    public void stopSelendroidServer() {
        if (driver != null) {
            driver.quit();
        }
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }
}
