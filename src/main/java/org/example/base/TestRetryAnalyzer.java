package org.example.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryMaxLimit  = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if(counter < retryMaxLimit) {
                counter++;
                return true;
            }
        }
        return false;
    }
}
