package ru.opencart.appmanager;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class HelperBase {

    protected Page page;

    public HelperBase(Page page) {
        this.page = page;
    }


    protected boolean isElementPresent(String locator) {
        try {
            page.locator(locator).isEditable();
            return true;
        } catch (TimeoutError e) {
            return false;
        }

    }
}
