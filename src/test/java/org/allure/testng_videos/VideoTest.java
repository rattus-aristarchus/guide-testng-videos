package org.allure.testng_videos;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class VideoTest {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setupDriver() throws MalformedURLException {
        driver = Util.createDriver();
    }

    @Test
    public void openWikipediaPage() {
        driver.get("https://en.wikipedia.org/wiki/Software_testing");

        Assert.assertTrue(driver.getTitle().contains("Software testing"));
        Util.attachVideo(driver);
    }

    @AfterMethod
    public void teardownDriver(){
        driver.quit();
    }

}
