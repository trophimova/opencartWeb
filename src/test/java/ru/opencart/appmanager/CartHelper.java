package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.opencart.model.ProductData;

import java.util.ArrayList;
import java.util.List;


public class CartHelper extends HelperBase {

    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void add(ProductData productData) {
        chooseProductGroup(productData.getProductGroup());
        addProduct(productData.getProductName());
    }

    private void chooseProductGroup(String cssSelector) {
        click(By.cssSelector(cssSelector));
    }

    private void addProduct(String cssSelector) {
        click(By.cssSelector(cssSelector));
        if (isElementPresent(By.id("input-option226"))) {
            click(By.id("input-option226"));
            WebElement dropdown = wd.findElement(By.id("input-option226"));
            dropdown.findElement(By.xpath("//option[@value= '15']")).click();
        }
        click(By.id("button-cart"));
    }

    public void openCart() {
        wd.findElement(By.id("cart")).click();
        wd.findElement(By.xpath("//ul[@class = 'dropdown-menu pull-right']//strong")).click();
    }

    public void delete(int index) {
        wd.findElements(By.xpath("//button[@class = 'btn btn-danger']")).get(index).click();
    }

    public boolean isThereAProduct() {
        return isElementPresent(By.xpath("//input[@size = '1']"));
    }


    public List<ProductData> list() {
        List<ProductData> products = new ArrayList<ProductData>();
        List<WebElement> elements = wd.findElements(By.xpath("//div[@class = 'table-responsive']//tbody//tr"));
        for (WebElement element : elements) {
            String name = getNameTitle(element.findElement(By.xpath("//div[@class = 'table-responsive']//tbody//tr//td[@class = 'text-left']/a")));
            ProductData product = new ProductData()
                    .withProductName(name)
                    .withProductGroup(null);
            products.add(product);
        }
        return products;
    }


}
