package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;

public class Documents extends HomePage{
    public Documents(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//div[@class='ui action input']/input")
    private WebElement searchDocumentInput;
    @FindBy(linkText = "Exports")
    private WebElement exportsFolderBtn;
    @FindBy(xpath = "//div[@class='ui fluid container']/div/div[@class='ui card']/div[@class='extra content']/div[@class='file left-floated']/a/following-sibling::a")
    private List<WebElement> deleteFileBtns;
    @FindBy(xpath = "//div[@class='ui fluid container']/div/div[@class='ui card']/div[@class='extra content']/div[@class='file left-floated']/a/i[@class='file icon']")
    private List<WebElement> addCommentBtns;
    @FindBy(xpath = "//button[@class='ui basic icon button custom-note-btn']/i")
    private WebElement addFileCommentBtn;
    @FindBy(xpath = "//div[@class='content']/form/textarea")
    private WebElement addNoteInput;
    @FindBy(xpath = "//div[@class='content']/following-sibling::div/button[@class='ui green button']/i")
    private WebElement saveNoteBtn;
    @FindBy(xpath = "//div[@class='note-text']/p")
    private WebElement myNote;
    @FindBy(xpath = "//div[@class='field']/div/following-sibling::a[text()='Exports']")
    private WebElement backToExportsBtn;
    public void verifyDocFunctionality(HashMap<String,String> data){
        navigate("documents");
        verifyRootAndExport(data);
    }

    private void verifyRootAndExport(HashMap<String,String> data){
        softAssert.assertTrue(searchDocumentInput.isEnabled(),"Search input is nt enabled");
        softAssert.assertTrue(exportsFolderBtn.isEnabled(),"Export button is nt enabled");
        exportsFolderBtn.click();

        for (int i = 0; i < deleteFileBtns.size(); i++) {
            softAssert.assertTrue(deleteFileBtns.get(i).isEnabled(),"Delete Button "+deleteFileBtns.get(i)+" is not enabled");

        }
        for (int i = 0; i < addCommentBtns.size(); i++) {
            softAssert.assertTrue(addCommentBtns.get(i).isEnabled(), "Delete Button " + addCommentBtns.get(i) + " is not enabled");
            addCommentBtns.get(i).click();
            addFileCommentBtn.click();
            addNoteInput.sendKeys(data.get("Comments"));
            softAssert.assertTrue(saveNoteBtn.isEnabled(), "save note button is not enabled");
            saveNoteBtn.click();
            softAssert.assertEquals(myNote, data.get("Comments"), "Note is not there");
            backToExportsBtn.click();
        }
    }
}
