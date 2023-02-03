package com.cogmento;

import com.cogmento.pages.Deals;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;

public class DealTest extends BaseTest{

    @Test(dataProvider = "deal")
    public void editDeals(HashMap<String, String> data){
        Login login= new Login(driver,softAssert);
        Deals deals = new Deals(driver, softAssert);
        login.navigateToLoginPage();
        login.login();
        deals.editDealsDetails(data);
    }
    @DataProvider(name = "deal")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "deal").getData();
    }
}
