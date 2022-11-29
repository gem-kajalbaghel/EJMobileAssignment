package com.gemini.mobile.stepdefinition;

import com.gemini.mobile.selectors.MobileXpath;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SerenityRunner.class)
public class PerfectoExpensesSteps extends PageObject {

    @Managed(driver = "appium")
    WebDriver driver;

    // AndroidDriver driver;

    public static final Logger LOGGER = LoggerFactory.getLogger(PerfectoExpensesSteps.class);

    @Given("^Application is launched$")
    public void applicationIsLaunched() throws MalformedURLException {
        File app = new File(System.getProperty("user.dir") + "\\app\\ExpenseAppVer1.0.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel 3");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10.0");
        cap.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Then("^Verify \"(.*)\" heading displays$")
    public void verifyApplicationLaunch(String expectedHeading) {
        String actualHeading = textOf(MobileXpath.appHeader);
        if (expectedHeading.contains(actualHeading)) {
            LOGGER.info("Heading verified successfully");
        } else {
            LOGGER.info("Unable to verify heading. Expected: " + expectedHeading + ", Actual: " + actualHeading);
            Assert.fail("Unable to verify heading. Expected: " + expectedHeading + ", Actual: " + actualHeading);
        }
    }

    @And("^User clicks on \"(.*)\" button$")
    public void clickOnButton(String btnName) {
        try {
            Thread.sleep(10000);
            switch (btnName) {
                case "Sign Up":
                    btnName = "login_signup_btn";
                    break;
                case "Register":
                    btnName = "signup_save_btn";
                    break;
                case "Login":
                    btnName = "login_login_btn";
                    break;
            }
            WebElement element = driver.findElement(MobileXpath.btn(btnName));
            if (element.isDisplayed()) {
                clickOn(element);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^Enter \"(.*)\" in \"(.*)\" field$")
    public void enterInField(String text, String field) {
        try {
            Thread.sleep(5000);
            WebElement element;
            if (field.contains("login")) {
                field = field.replaceAll(" ", "_");
                element = driver.findElement(MobileXpath.loginField(field));
            } else {
                Thread.sleep(5000);
                element = driver.findElement(MobileXpath.textField(field));
            }
            typeInto(element, text);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^Enter password in \"(.*)\" field$")
    public void enterPasswordInField(String field) {
        if (field.contains(" ") && field.contains("login")) {
            field = field.replaceAll(" ", "_");
            WebElement element = driver.findElement(MobileXpath.loginField(field));
            typeInto(element, "samplePass@123");
        } else {
            field = field.replaceAll(" ", "_");
            WebElement element = driver.findElement(MobileXpath.textField(field));
            typeInto(element, "samplePass@123");
        }
    }


    @Then("^Select \"(.*)\" from \"(.*)\" dropdown$")
    public void selectFromDropdown(String dropdownValue, String field) {
        try {
            Thread.sleep(5000);
            WebElement element = driver.findElement(MobileXpath.dropdown(field));
            if (element.isDisplayed()) {
                element.click();
                if (dropdownValue.equals("INR")) {
                    Thread.sleep(5000);
                    WebElement actualDropdown = driver.findElement(MobileXpath.dropdownValue(2));
                    if (actualDropdown.isDisplayed()) {
                        actualDropdown.click();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify Expenses page displays$")
    public void verifyPageDisplays()
    {
        try {
            Thread.sleep(5000);
            if ($(MobileXpath.expensesPage).isPresent()) {
                LOGGER.info("Expenses page verified successfully");
            } else {
                LOGGER.info("Expenses page does not display");
                Assert.fail("Expenses page does not display");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
}
