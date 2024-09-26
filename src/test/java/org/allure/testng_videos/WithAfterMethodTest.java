package org.allure.testng_videos;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class WithAfterMethodTest {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setupDriver() throws MalformedURLException {
        driver = Util.createDriver();
    }

    @Test
    public void openWikipediaPage() {
        driver.get("https://en.wikipedia.org/wiki/Software_testing");

        // intentional failure
        Assert.assertFalse(driver.getTitle().contains("Software testing"));
    }

    @AfterMethod
    public void attachVideoOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            Util.attachVideo(driver);
        }
    }

    @AfterMethod
    public void teardownDriver() {
        driver.quit();
    }

}
