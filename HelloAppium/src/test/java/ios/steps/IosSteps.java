package ios.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class IosSteps {

    IOSDriver<IOSElement> driver;

    //Scenario: Test the alert function - BEGIN
    @When("^I access the UICatalogApp$")
    public void iAccessTheUICatalogApp() throws Throwable {
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        d.setCapability(MobileCapabilityType.APP, "/Users/renanchagas/Documents/Workspace-UDEMY/drivers/UICatalog.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),d);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^I click the alert button$")
    public void iClickTheAlertButton() throws Throwable {
        driver.findElementByAccessibilityId("Alert Views").click();
    }

    @And("^I click the text entry button$")
    public void iClickTheTextEntryButton() throws Throwable {
        driver.findElementByAccessibilityId("Text Entry").click();
    }

    @And("^I type the text \"([^\"]*)\"$")
    public void iTypeTheText(String input) throws Throwable {
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys(input);
    }

    @Then("^I click the ok button$")
    public void iClickTheOkButton() throws Throwable {
        driver.findElementByName("OK").click();
        driver.navigate().back();
    }
    //Scenario: Test the alert function - END

    //Scenario: Test the scroll function and index elements - BEGIN
    @When("^I scroll down$")
    public void iScroolDown() throws Throwable {
        RemoteWebElement parent = driver.findElementByClassName("XCUIElementTypeTable");
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);

        scrollObject.put("predicateString", "name == 'Steppers'");
        driver.executeScript("mobile:scroll", scrollObject);
    }

    @And("^I click the Steppers button$")
    public void iClickTheSteppersButton() throws Throwable {
        driver.findElementByAccessibilityId("Steppers").click();
    }

    @And("^I increment an value on index (\\d+)$")
    public void iIncrementAnValueOnIndex(int index) throws Throwable {
        driver.findElementsByAccessibilityId("Increment").get(index).click();
    }

    @Then("^I check the text on index (\\d+)$")
    public void iCheckTheTextOnIndex(int index) throws Throwable {
        System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(index).getText());
    }
    //Scenario: Test the scroll function and index elements - END

    //Scenario: Test the picker function - BEGIN
    @When("^I click the Picker View button$")
    public void iClickThePickerViewButton() throws Throwable {
        driver.findElementByAccessibilityId("Picker View").click();
    }

    @And("^I type a number \"([^\"]*)\" on index (\\d+)$")
    public void iTypeANumberOnIndex(String value, int index) throws Throwable {
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(index).sendKeys(value);
    }
    //Scenario: Test the picker function - END
}
