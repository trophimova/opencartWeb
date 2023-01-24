package ru.opencart;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class BaseTest {

    private Browser browser;
    protected Page page;
    private BrowserContext context;
    private Boolean isTraceEnabled = true;

    @BeforeSuite
    public void setUp() {
        browser = Playwright
                .create()
                .webkit()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        context = browser.newContext();

        if(isTraceEnabled){
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));
        }

        page = context.newPage();
    }

    @AfterSuite
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

    @AfterMethod
    public void attachFilesToFailedTest(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            String uuid = UUID.randomUUID().toString();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("build/allure-results/screenshot_" + uuid + "screenshot.png"))
                    .setFullPage(true));

            Allure.addAttachment(uuid, new ByteArrayInputStream(screenshot));
            Allure.addAttachment("source.html", "text/html", page.content());

            if (isTraceEnabled) {
                String traceFileName = String.format("build/%s_trace.zip", uuid);
                Path tracePath = Paths.get(traceFileName);
                context.tracing()
                        .stop(new Tracing.StopOptions()
                                .setPath(tracePath));
                Allure.addAttachment("trace.zip", new ByteArrayInputStream(Files.readAllBytes(tracePath)));
            }
        }
    }
}
