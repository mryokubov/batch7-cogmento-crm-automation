package com.cogmento;

import com.cogmento.pages.Calendar;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CalendarTest extends BaseTest{

    @Test(dataProvider = "calendar")
    public void createEventCalendar(HashMap<String,String> data){
        Login login = new Login(driver, softAssert);
        Calendar calendar=new Calendar(driver,softAssert);
        login.navigateToLoginPage();
        login.login();
        calendar.createEventInCalendar(data);
    }
    @DataProvider(name = "calendar")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "calendar").getData();
    }
}
