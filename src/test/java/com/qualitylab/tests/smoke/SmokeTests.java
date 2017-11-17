package com.qualitylab.tests.smoke;
import com.qualitylab.steps.EmailSteps;
import com.qualitylab.steps.LoginSteps;
import com.qualitylab.steps.MainPageSteps;
import com.qualitylab.tests.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class SmokeTests extends BaseTest {
    WebDriver driver = getDriver();
    MainPageSteps mainPage = new MainPageSteps(driver);
    EmailSteps emailSteps = new EmailSteps(driver);
    LoginSteps loginSteps = new LoginSteps(driver);

    @Then("^close driver and browser$")
    public void close_driver_and_browser() throws Throwable {
        shutDown();
    }

    @Given("on main page")
    public void on_main_page() throws IOException, InterruptedException {
        openSite();
    }

    @When("^enter \"([^\"]*)\" as login$")
    public void enter_as_login(String login) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginSteps.enterLogin(login);
    }

    @When("^enter \"([^\"]*)\" as password$")
    public void enter_as_password(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginSteps.enterPassword(password);
    }

    @When("^click \"([^\"]*)\" button$")
    public void click_button(String button) {
         loginSteps.clickButton(button);
        emailSteps.waitForEmailPageLoaded();
    }

    @When("^create a new email$")
    public void create_a_new_email() {
        emailSteps.writeEmaile();
    }

    @When("^enter \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void enter_in_field(String text, String field){
        emailSteps.addTextToInput(text, field);
    }

    @Then("^an email was sent$")
    public void an_email_was_sent_and_message(){
        Assert.assertTrue(emailSteps.emailSentMessagePresent(), "No email sent message present on page");
    }


}
