package com.qualitylab.steps;

import com.qualitylab.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }
    public void enterLogin(String login) {
        loginPage.loginInput.clear();
        loginPage.loginInput.sendKeys(login);
    }
    public void enterPassword(String password) {

        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(password);
    }

    public void clickButton(String button){
        loginPage.getButton(button).click();

    }

}
