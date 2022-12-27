package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task11 extends BaseTest {
    /*
    Go to URL: https://www.monsterindia.com/seeker/registration
Upload file.
     */

    @Test
    public void test(){
        driver.get("https://www.monsterindia.com/seeker/registration");
        WebElement uploadResume = driver.findElement(By.id("file-upload"));
        uploadResume.sendKeys("/Users/apple-pc/IdeaProjects/CWJunitSelenium/src/test/java/resources/robot.txt");

    }
}
