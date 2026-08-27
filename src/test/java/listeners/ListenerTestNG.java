package listeners;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class ListenerTestNG implements IRetryAnalyzer, ITestListener {
    private final int maxRetries = 3;
    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetries) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("FAILED TEST %s Duration: %ss %n", result.getName(),
                getExecutionTime(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf("SKIPING TEST %s %n", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.printf("STARTING TEST %s %n", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("FINISHED TEST %s Duration: %ss %n", result.getName(),
                getExecutionTime(result));
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private long getExecutionTime(ITestResult result) {
        return Duration.ofMillis(result.getEndMillis() - result.getStartMillis()).toSeconds();
    }
}
