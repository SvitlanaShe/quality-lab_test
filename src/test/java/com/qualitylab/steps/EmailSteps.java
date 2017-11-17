package com.qualitylab.steps;

import com.qualitylab.pages.EmailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class EmailSteps {
    private WebDriver driver;
    private EmailPage emailPage;

    public EmailSteps(WebDriver driver) {
        this.driver = driver;
        emailPage = new EmailPage(driver);
    }

    public void writeEmaile() {
        emailPage.writeNewEmail.click();
    }

    public void addTextToInput(String text, String field) {
        WebElement element = emailPage.getField(field);
        element.sendKeys("    " + text);
        driver.switchTo().defaultContent();
    }
    public void waitForEmailPageLoaded() {
        emailPage.waitForPageLoaded();
    }

    public boolean emailSentMessagePresent() {

        return emailPage.sentMessagePresent();
    }
    //
//    WebDriverWait wait;
//    public void waitForFilterPresent(String manufacture){
//        MainPage mainPage = new MainPage(driver);
//        wait = new WebDriverWait(driver, 3000);
//        wait.until(ExpectedConditions
//                .presenceOfElementLocated(mainPage.getByFilterForManufacture(manufacture)));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
