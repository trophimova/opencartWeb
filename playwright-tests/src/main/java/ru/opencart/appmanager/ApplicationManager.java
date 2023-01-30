package ru.opencart.appmanager;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class ApplicationManager {
    protected Page page;
    protected BrowserContext context;
    protected Boolean isTraceEnabled = true;

    private AuthHelper authHelper;
    private NavigationHelper navigationHelper;
    private RegistrationHelper registrationHelper;
    private CartHelper cartHelper;
    protected Browser browser;
    private final String browserType;

    public ApplicationManager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        Playwright playwright = Playwright.create();
        switch (browserType) {
            case "firefox": {
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            }
            case "chromium": {
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            }
            case "webkit": {
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            }
        }


        context = browser.newContext();

        if(isTraceEnabled){
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));
        }

        page = context.newPage();
        registrationHelper = new RegistrationHelper(page);
        navigationHelper = new NavigationHelper(page);
        authHelper = new AuthHelper(page);
        cartHelper = new CartHelper(page);
    }

    public void stop() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }


    public void attachFilesToTest(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            String uuid = UUID.randomUUID().toString();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("build/allure-results/screenshot_" + uuid + "screenshot.png"))
                    .setFullPage(true));

            Allure.addAttachment(uuid, new ByteArrayInputStream(screenshot));


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

    public AuthHelper authorization() {
        return authHelper;
    }

    public RegistrationHelper registration() {
        return registrationHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public CartHelper cart() {
        return cartHelper;
    }
}
