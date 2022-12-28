package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartHelper extends HelperBase {

    public CartHelper(WebDriver wd) {
        super(wd);
    }

    public void addToCart() {
        wd.manage().window().setSize(new Dimension(1936, 1056));
        wd.findElement(By.cssSelector(".product-layout:nth-child(2) .hidden-xs")).click();
        wd.findElement(By.cssSelector(".product-layout:nth-child(1) .hidden-xs")).click();
        wd.findElement(By.id("input-option226")).click();
        {
            WebElement dropdown = wd.findElement(By.id("input-option226"));
            dropdown.findElement(By.xpath("//option[@value= '15']")).click();
        }
        wd.findElement(By.id("button-cart")).click();
        wd.findElement(By.id("cart")).click();
        wd.findElement(By.xpath("//ul[@class = 'dropdown-menu pull-right']//strong")).click();
    }

}
