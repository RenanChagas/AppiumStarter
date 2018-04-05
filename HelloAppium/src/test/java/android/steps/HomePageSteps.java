package android.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HomePageSteps {

    private AndroidDriver driver;

    /*
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app",
                "/Users/renanchagas/Documents/Workspace-UDEMY/Mobile-Test-Appium/HelloAppium/app/quikr.apk");
        desiredCapabilities.setCapability("deviceName", "nexus6");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "Appium");
        desiredCapabilities.setCapability("platformVersion", "5.1");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }
    */

    @When("^I launch Quikr app$")
    public void iLaunchQuikrApp() throws Throwable {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app",
                "/Users/renanchagas/Documents/Workspace-UDEMY/Mobile-Test-Appium/HelloAppium/app/quikr.apk");
        desiredCapabilities.setCapability("deviceName", "nexus6");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "Appium");
        desiredCapabilities.setCapability("platformVersion", "5.1");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.findElementById("android:id/button1").click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @And("^I choose to log in using Google$")
    public void iChooseToLogInUsingGoogle() throws Throwable {
       driver.findElement(By.id("sign_in_button")).click();
    }

    @Then("^I see account picker screen with my email address \"([^\"]*)\"$")
    public void iSeeAccountPickerScreenWithMyEmailAddress(String expected) throws Throwable {
        driver.findElement(By.id("login_register_view")).sendKeys(expected);
        Thread.sleep(5000);
        Assert.assertEquals("Email Id matches", expected,
                driver.findElement(By.id("login_register_view")).getText());
    }

}
