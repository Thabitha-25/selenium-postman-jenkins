package com.login.tests;

import com.login.base.BaseTest;
import com.login.pages.LoginPage;
import com.login.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage securePage = new SecureAreaPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                loginPage.getMessage().contains("You logged into a secure area"),
                "Valid login failed"
        );

        Assert.assertTrue(
                securePage.isSecurePageDisplayed(),
                "Secure area page not displayed"
        );
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wronguser", "wrongpass");

        Assert.assertTrue(
                loginPage.getMessage().contains("Your username is invalid"),
                "Invalid login error not shown"
        );
    }

    @Test
    public void emptyFieldsTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        Assert.assertTrue(
                loginPage.getMessage().contains("Your username is invalid"),
                "Validation message missing"
        );
    }
}
