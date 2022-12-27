package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;;

public class C10_FileUpload extends BaseTest{


    @Test
    public void fileUpload(){

        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz 
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("/Users/apple-pc/Desktop/fileExist.jpg");

        // Upload butonuna basiyoruz
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        
        // Upload edilme mesajinin goruntulendigini dogruluyoruz
        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        /*
        List <WebElement> uploadedMessage = driver.findElements(By.tagName("h8"));
        Assert.assertFalse("Element Bulunamadı",uploadedMessage.isEmpty());
         */
        
        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("File Uploaded!" ,uploadedMessage.getText());

    }

}