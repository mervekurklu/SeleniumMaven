package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class Task08 extends BaseTest {
    /*
    Go to URL: https://demoqa.com/browser-windows
Click on the windows - "WindowButton"
Click on all the child windows.
Print the text present on all the child windows in the console.
Print the heading of the parent window in the console.
     */

    @Test
    public void HandlesTest() {
        driver.get("https://demoqa.com/browser-windows");
        String homepageId = driver.getWindowHandle();
        WebElement windowButtonId = driver.findElement(By.id("windowButton"));
        windowButtonId.click();
        driver.switchTo().window(homepageId);

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();
        driver.switchTo().window(homepageId);

        WebElement messageButton = driver.findElement(By.id("messageWindowButton"));
        messageButton.click();
        driver.switchTo().window(homepageId);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
        while (i.hasNext()) {
            String Button = i.next();
            driver.switchTo().window(Button);

            if (!driver.getWindowHandle().equals(homepageId)) {
                WebElement element = driver.findElement(By.xpath("//*[text()]"));
                System.out.println(element.getText());
                driver.close();

            }
            driver.switchTo().window(homepageId);
            System.out.println(driver.getTitle());

        }
    }
}



