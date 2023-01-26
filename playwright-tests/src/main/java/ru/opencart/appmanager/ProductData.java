package ru.opencart.appmanager;

public class ProductData {
    private final String productGroup;
    private final String productName;

    public ProductData(String productGroup, String productName) {
        this.productGroup = productGroup;
        this.productName = productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public String getProductName() {
        return productName;
    }
}
