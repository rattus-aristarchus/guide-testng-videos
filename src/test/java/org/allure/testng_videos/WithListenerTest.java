package org.allure.testng_videos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


@Listeners({org.allure.testng_videos.Listener.class})
public class WithListenerTest {

    protected static RemoteWebDriver staticDriver;

    @BeforeMethod
    public void setupDriver() throws MalformedURLException {
        staticDriver = Util.createDriver();
    }

    @Test
    public void openWikipediaPage() {
        staticDriver.get("https://en.wikipedia.org/wiki/Software_testing");

        Assert.assertFalse(staticDriver.getTitle().contains("Software testing"));
    }

    @AfterMethod
    public void teardownDriver(){
        staticDriver.quit();
    }

}
