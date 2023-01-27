package ru.opencart.appmanager;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import ru.opencart.model.ProductData;

import java.util.ArrayList;
import java.util.List;

public class CartHelper extends HelperBase {


    public CartHelper(Page page) {
        super(page);
    }

    public void add(ProductData productData) throws InterruptedException {
        chooseProductGroup(productData.getProductGroup());
        addProduct(productData.getProductName());
    }

    private void addProduct(String locator) throws InterruptedException {
        page.locator(locator).click();

        Thread.sleep(1000l);

        if(page.isVisible(select)) {
            page.selectOption(select,"15");
        }
        page.locator(cartButton).click();
    }

    private void chooseProductGroup(String locator) {
        page.click(locator);
    }

    public List<ProductData> list() {
        List<ProductData> products = new ArrayList<ProductData>();
        List<ElementHandle> elements = page.querySelectorAll("xpath=//div[@class = 'table-responsive']//tbody//tr");
        for (ElementHandle element : elements) {
            ProductData product = new ProductData();
            products.add(product);
        }
        return products;
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
