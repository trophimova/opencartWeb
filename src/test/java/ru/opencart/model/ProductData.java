package ru.opencart.model;

import java.util.Objects;

public class ProductData {
    private String productName;
    private String productGroup;


    public String getProductName() {
        return productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public ProductData withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductData withProductGroup(String productGroup) {
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
