package org.allure.testng_videos;

import io.qameta.allure.Allure;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Util {

    private static final String SELENOID_URL = "http://localhost:4444";

    public static RemoteWebDriver createDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "125.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
        }});

        return new RemoteWebDriver(new URL(SELENOID_URL + "/wd/hub"), options);
    }

    public static void attachVideo(RemoteWebDriver driver) {
        String URL = SELENOID_URL +  "/video/" + driver.getSessionId() + ".mp4";
        String html = "<html><body><video width='100%' height='100%' controls autoplay>" +
                "<source src='" + URL + "' type='video/mp4'></video></body></html>";
        Allure.addAttachment("video", "text/html", html, ".html");
    }

}
