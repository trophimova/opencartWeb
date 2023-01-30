package ru.opencart.appmanager;


import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import ru.opencart.model.ProductData;

import java.util.ArrayList;
import java.util.List;

public class CartHelper extends HelperBase {


    public CartHelper(Page page) {
        super(page);
    }

    public void add(ProductData productData) {
        chooseProductGroup(productData.getProductGroup());
        addProduct(productData.getProductName());
    }

    private void addProduct(String locator) {
        page.locator(locator).click();
        if(isElementPresent(select)) {
            page.locator(select).click();
            page.selectOption(select,"15");
        }
        page.locator(cartButton).click();
    }

    private void chooseProductGroup(String locator) {
        page.click(locator);
    }

    public List<ProductData> list() {
        List<ProductData> products = new ArrayList<ProductData>();
        if (waitForElements("xpath=//div[@class = 'table-responsive']//tbody//tr")) {
            List<ElementHandle> elements = page.querySelectorAll("xpath=//div[@class = 'table-responsive']//tbody//tr");
            for (ElementHandle element : elements) {
                ProductData product = new ProductData();
                products.add(product);
            }
            return products;
        }

        List<ElementHandle> elements = page.querySelectorAll("xpath=//div[@class = 'table-responsive']//tbody//tr");
        for (ElementHandle element : elements) {
            ProductData product = new ProductData();
            products.add(product);
        }
        return products;
    }

    protected boolean waitForElements(String locator) {
        try {
            page.locator(locator).first().waitFor();
            return true;
        } catch (TimeoutError e) {
            return false;
        }

    }



    public void delete(int index) {
        page.querySelectorAll("xpath=//button[@class = 'btn btn-danger']").get(index).click();
    }
    public static final String cameras = "li:nth-child(7) > a";
    private final String cartButton = "[id=button-cart]";
    public static final String camera1 = ".product-layout:nth-child(1) .caption a";
    public static final String camera2 = ".product-layout:nth-child(2) .caption a";
    private final String select = "[id=input-option226]";



}
