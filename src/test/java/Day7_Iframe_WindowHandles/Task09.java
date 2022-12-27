package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.List;

public class Task09 extends BaseTest {
    /*
    Go to URL: http://demo.guru99.com/test/guru99home/
Find the number of iframes on the page.
Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
Exit the iframe and return to the main page.
     */

    @Test
public void iframeTest(){
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        driver.switchTo().defaultContent();











    }
}
