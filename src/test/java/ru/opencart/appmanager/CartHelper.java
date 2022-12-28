package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CartHelper extends HelperBase {

    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void addToCart() {
        wd.manage().window().setSize(new Dimension(1936, 1056));
        wd.findElement(By.cssSelector(".product-layout:nth-child(1) .hidden-xs")).click();
        wd.findElement(By.id("input-option226")).click();
        {
            WebElement dropdown = wd.findElement(By.id("input-option226"));
            dropdown.findElement(By.xpath("//option[. = 'Red']")).click();
        }
        wd.findElement(By.id("button-cart")).click();
        wd.findElement(By.id("cart-total")).click();
    }

}
