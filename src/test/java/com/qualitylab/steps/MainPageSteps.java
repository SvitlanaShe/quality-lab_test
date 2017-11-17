package com.qualitylab.steps;

import com.qualitylab.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPageSteps {

    public WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

}
