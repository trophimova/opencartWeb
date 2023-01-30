package ru.opencart.appmanager;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class HelperBase {

    protected static Page page;

    public HelperBase(Page page) {
        this.page = page;
    }



}
