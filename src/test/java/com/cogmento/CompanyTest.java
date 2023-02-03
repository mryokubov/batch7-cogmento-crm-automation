package com.cogmento;

import com.cogmento.pages.Companies;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CompanyTest extends BaseTest{
    @Test(dataProvider = "companies")
    public void createCompanyPositive(HashMap<String,String> data) {
        Login login = new Login(driver, softAssert);
        Companies companies = new Companies(driver,softAssert);
        login.navigateToLoginPage();
        login.login();
        companies.createNewCompany(data);
    }
    @DataProvider(name = "companies")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "companies").getData();
    }
}
