package ru.opencart.appmanager;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class HelperBase {

    protected Page page;

    public HelperBase(Page page) {
        this.page = page;
    }



}
