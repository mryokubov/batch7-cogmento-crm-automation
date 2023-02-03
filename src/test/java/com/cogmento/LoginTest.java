package com.cogmento;

import com.cogmento.pages.Login;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTestPositive(){
        Login login = new Login(driver, softAssert);
        login.navigateToLoginPage();
        login.login();
    }

    @Test
    public void loginTestNegative(){
        Login login = new Login(driver, softAssert);
        login.navigateToLoginPage();
        login.loginNegative();
    }
}
