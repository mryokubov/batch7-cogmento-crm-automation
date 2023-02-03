package com.cogmento;

import com.cogmento.pages.Documents;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DocumentsTest extends  BaseTest{
    @Test(dataProvider = "documents")
    public void verifyDocumentsPageFunctionality(HashMap<String,String> data){
        Login login = new Login(driver, softAssert);
        Documents documents = new Documents(driver,softAssert);
        login.navigateToLoginPage();
        login.login();
        documents.verifyDocFunctionality(data);

    }

    @DataProvider(name = "documents")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "documents").getData();
    }
}
