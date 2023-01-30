package ru.opencart.model;

import com.microsoft.playwright.Locator;

import java.util.Objects;

public class ProductData {
    private Locator productGroup;
    private Locator productName;


    public Locator getProductGroup() {
        return productGroup;
    }

    public Locator getProductName() {
        return productName;
    }

    public ProductData withProductName(Locator productName) {
        this.productName = productName;
        return this;
    }

    public ProductData withProductGroup(Locator productGroup) {
        this.productGroup = productGroup;
        return this;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "productGroup='" + productGroup + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductData that = (ProductData) o;

        if (!Objects.equals(productGroup, that.productGroup)) return false;
        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        int result = productGroup != null ? productGroup.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}
