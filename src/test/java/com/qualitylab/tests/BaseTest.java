package com.qualitylab.tests;

import com.qualitylab.WebDriverFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseTest {

    public static WebDriver driver;

    public  void openSite() throws IOException {
        openMainPage();
    }

     public BaseTest () {
         WebDriverFactory F = null;
         try {
             F = new WebDriverFactory();
         } catch (IOException e) {
             e.printStackTrace();
         }
         driver = F.getDriver();
    }

    public static WebDriver getDriver(){
        return WebDriverFactory.getDriver();
    }


     void openMainPage() throws IOException {

         Properties properties = new Properties();
        try(InputStream stream = getClass().getResourceAsStream("/url.properties")){
            properties.load(stream);
            driver.get( properties.getProperty("mainURI").toString() );
        }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS );
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

    }

    public void shutDown(){
        if(driver!=null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

}
