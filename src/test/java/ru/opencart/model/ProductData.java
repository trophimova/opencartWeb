package ru.opencart.model;

import org.openqa.selenium.By;

public class ProductData {
    private final String productName;
    private final By productGroup;

    public ProductData(String productName, By productGroup) {
        this.productName = productName;
        this.productGroup = productGroup;
    }

    public String getProductName() {
        return productName;
    }

    public By getProductGroup() {
        return productGroup;
    }
}
