package com.qualitylab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "mailbox:login")
    public WebElement loginInput;

    @FindBy(id = "mailbox:domain")
    public WebElement domainLogin;

    @FindBy(id = "mailbox:password")
    public WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getButton(String button) {
        if(button.equals("Отправить")){
            return driver.findElement(By.xpath("//span[text()='" + button + "']"));
        }
        return driver.findElement(By.xpath("//input[@value='" + button + "']"));
    }

}
