package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartHelper extends HelperBase {

    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void addToCart(String locator, By productGroup) {
        click(productGroup);
        addProduct(locator);
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

    public void deleteFromCart() {
        click(By.xpath("//button[@class = 'btn btn-danger']"));
    }

    public boolean isThereAProduct() {
        return isElementPresent(By.xpath("//input[@size = '1']"));
    }


}
