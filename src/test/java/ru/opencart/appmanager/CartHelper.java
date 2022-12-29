package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.opencart.model.ProductData;


public class CartHelper extends HelperBase {

    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void addToCart(ProductData productData) {
        click(productData.getProductGroup());
        addProduct(productData.getProductName());
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

    public void deleteFromCart(int index) {
        wd.findElements(By.xpath("//button[@class = 'btn btn-danger']")).get(index).click();
        //click(By.xpath("//button[@class = 'btn btn-danger']"));
    }

    public boolean isThereAProduct() {
        return isElementPresent(By.xpath("//input[@size = '1']"));
    }


}
