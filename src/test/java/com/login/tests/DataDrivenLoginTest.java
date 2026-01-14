package com.login.tests;

import com.login.base.BaseTest;
import com.login.pages.LoginPage;
import com.login.utils.CSVReaderUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return CSVReaderUtil.readCSV("testdata/loginData.csv");
    }

    @Test(dataProvider = "loginData")
    public void loginWithMultipleData(
            String username,
            String password,
            String expectedMessage) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.getMessage().contains(expectedMessage),
                "Expected message not matched"
        );
    }
}
