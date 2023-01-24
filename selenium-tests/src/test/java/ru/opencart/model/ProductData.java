package ru.opencart.model;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ProductData {
    private WebElement productName;
    private WebElement productGroup;


    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductGroup() {
        return productGroup;
    }

    public ProductData withProductName(WebElement productName) {
        this.productName = productName;
        return this;
    }

    public ProductData withProductGroup(WebElement productGroup) {
        this.productGroup = productGroup;
        return this;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "productName='" + productName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductData that = (ProductData) o;

        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return productName != null ? productName.hashCode() : 0;
    }
}
