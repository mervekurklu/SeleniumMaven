package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Task10 extends BaseTest {
    // Go to https://the-internet.herokuapp.com/download
   //  Download sample.png file
  //  Then verify if the file downloaded successfully

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement samplelink= driver.findElement(By.linkText("sample.png"));
        samplelink.click();

        String filePath="/Users/apple-pc/Downloads/sample.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
        System.out.println(Files.exists(Paths.get(filePath)));

    }

}
