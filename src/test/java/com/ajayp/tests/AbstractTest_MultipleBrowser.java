package com.ajayp.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest_MultipleBrowser {

    protected WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws MalformedURLException {
       if(Boolean.getBoolean("selenium-grid.enabled")) {
           this.driver = getRemoteDriver(browser);
       }else{
           this.driver = getLocalDriver();
       }
    }

    private WebDriver getLocalDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        return this.driver;
    }

    private WebDriver getRemoteDriver(String browser) throws MalformedURLException {
        Capabilities capabilities;
        //if(System.getProperty("browser").equalsIgnoreCase("chrome")){
        if(browser.equalsIgnoreCase("chrome")){
            capabilities = new ChromeOptions();
        }else{
            capabilities = new FirefoxOptions();
        }
       return new RemoteWebDriver(new URL("http://13.239.28.232:4445/wd/hub"),capabilities);
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
