package ru.opencart.appmanager;


import com.microsoft.playwright.Page;

public class HelperBase {

    public Page page;

    public HelperBase(Page page) {
        this.page = page;
    }


}
