package org.allure.testng_videos;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // this hook executes, however, the video doesn't appear in the report
        Util.attachVideo(WithListenerTest.staticDriver);
    }

}