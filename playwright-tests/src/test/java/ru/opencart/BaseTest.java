package ru.opencart;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private Browser browser;
    protected Page page;
    private BrowserContext context;
    private Boolean isTraceEnabled = false;

    @BeforeSuite
    public void setUp() {
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

        context = browser.newContext();

        if(isTraceEnabled){
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));
        }

        page = context.newPage();
    }
}
