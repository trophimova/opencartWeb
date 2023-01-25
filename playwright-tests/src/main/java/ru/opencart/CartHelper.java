package ru.opencart;


import com.microsoft.playwright.Page;

public class CartHelper extends HelperBase {

    private final Page page;

    public CartHelper(Page page) {
        this.page = page;
    }

}
