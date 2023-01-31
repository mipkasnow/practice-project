package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private final int maxCount = 3;

    @Override
    public boolean retry(ITestResult result) {

        if(!result.isSuccess()){
            if(count < maxCount){
                count++;
                return true;
            }
        }

        return false;
    }
}
