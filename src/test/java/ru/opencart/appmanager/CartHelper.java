package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartHelper extends HelperBase {

    public CartHelper(ChromeDriver wd) {
        super(wd);
    }

    public void addToCart() {
        click(By.cssSelector(".product-layout:nth-child(1) .hidden-xs"));
        click(By.id("input-option226"));
        click(By.xpath("//option[. = 'Red']"));
        click(By.id("button-cart"));
    }

}
