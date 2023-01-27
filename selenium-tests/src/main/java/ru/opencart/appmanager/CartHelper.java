package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


    private void chooseProductGroup(WebElement webElement) {
        click(webElement);
    }


    private void addProduct(WebElement webElement) {
        click(webElement);
        if (isElementPresent(By.id("input-option226"))) {
            click(By.id("input-option226"));
            WebElement dropdown = wd.findElement(By.id("input-option226"));
            dropdown.findElement(By.xpath("//option[@value= '15']")).click();
        }
        click(By.id("button-cart"));
    }


    public void delete(int index) {
        wd.findElements(By.xpath("//button[@class = 'btn btn-danger']")).get(index).click();
    }



    public List<ProductData> list() {
        List<ProductData> products = new ArrayList<ProductData>();
        List<WebElement> elements = wd.findElements(By.xpath("//div[@class = 'table-responsive']//tbody//tr"));
        for (WebElement element : elements) {
            ProductData product = new ProductData();
            products.add(product);
        }
        return products;
    }



    @FindBy(css = "li:nth-child(7) > a")
    public static WebElement cameras;

    @FindBy(id = "button-cart")
    private WebElement cartButton;

    @FindBy(css = ".product-layout:nth-child(1) .caption a")
    public static WebElement camera1;

    @FindBy(css = ".product-layout:nth-child(2) .caption a")
    public static WebElement camera2;

    @FindBy(id = "input-option226")
    private WebElement select;

}
