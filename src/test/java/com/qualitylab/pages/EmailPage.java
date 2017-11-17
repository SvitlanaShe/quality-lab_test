package com.qualitylab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class EmailPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Написать письмо']")
    public WebElement writeNewEmail;
    private By bySentMessage = By.xpath("//div[@class='message-sent__title']");

    @FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
    private WebElement iframe;

    @FindBy(id = "tinymce")
    private WebElement tinymce;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getField(String field) {
        By byElement;
        if(field.toLowerCase().equals("body")) {
            byElement=By.xpath("//body[@class='mceContentBody compose2']");
            driver.switchTo().frame(iframe);
            tinymce.clear();
            return driver.findElement(byElement);
        }
        byElement = By.xpath("//span[text()='"+field+"']/../../../div[2]//*[contains(@class,'b-input')]");
        waitForElement(byElement);

       return driver.findElement(byElement);
    }


    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement newEmail;
        newEmail= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Написать письмо']")));
    }

    public void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement newEmail;
        newEmail= wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean sentMessagePresent() {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(bySentMessage));
        try {
            driver.findElement(bySentMessage);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
