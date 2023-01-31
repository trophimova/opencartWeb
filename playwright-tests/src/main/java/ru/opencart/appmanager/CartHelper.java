package ru.opencart.appmanager;


import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
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

    private void addProduct(Locator locator) {
        locator.click();
        if(select.isVisible()) {
            select.click();
            select.selectOption("15");
        }
        cartButton.click();
    }


    private void chooseProductGroup(Locator locator) {
        locator.click();
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




    Locator cartButton = page.locator("[id=button-cart]");

    Locator select = page.locator("[id=input-option226]");
    public static Locator cameras = page.locator("li:nth-child(7) > a");

    public static Locator camera1 = page.locator(".product-layout:nth-child(1) .caption a");
    public static Locator camera2 = page.locator(".product-layout:nth-child(2) .caption a");




}
