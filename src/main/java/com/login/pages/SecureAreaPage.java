package com.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private By heading = By.tagName("h2");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSecurePageDisplayed() {
        return driver.getCurrentUrl().contains("/secure")
                && driver.findElement(heading).isDisplayed();
    }
}
