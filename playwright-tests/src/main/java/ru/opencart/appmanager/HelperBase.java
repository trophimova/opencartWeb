package ru.opencart.appmanager;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class HelperBase {

    protected Page page;

    public HelperBase(Page page) {
        this.page = page;
    }


}
