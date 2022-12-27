package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03_RobotClass extends BaseTest {
    @Test
    public void test() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("/Users/apple-pc/IdeaProjects/CWJunitSelenium/src/test/java/resources/robot.txt");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);// tuşa basılı tutarak ctrl ye bastık
        robot.keyPress(KeyEvent.VK_S);// S tuşuna basılı tuttuk her ikisine basılı tutma komutu ile kaydettik
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_CONTROL);// Controlu serbest bıraktık
        robot.keyRelease(KeyEvent.VK_S);// S den elimizi kaldırdık
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_ENTER);// ENterladık
        robot.keyRelease(KeyEvent.VK_ENTER);// EnTEr tuşundan elimizi çektik bıraktık

        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
