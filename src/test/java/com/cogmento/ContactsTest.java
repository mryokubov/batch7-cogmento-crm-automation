package com.cogmento;

import com.cogmento.pages.Contacts;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ContactsTest extends BaseTest{

    @Test(dataProvider = "contacts")
    public void createContactPositive(HashMap<String,String> data) throws InterruptedException {
        extentTest = reports.startTest("Cogmento CRM Create Contact Positive Test");
        Login login = new Login(driver);
        Contacts contacts = new Contacts(driver);

        login.navigateToLoginPage();
        login.login();
        contacts.createContact(data);
        Thread.sleep(5000);
    }

    @DataProvider(name = "contacts")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "contacts").getData();
    }
}
