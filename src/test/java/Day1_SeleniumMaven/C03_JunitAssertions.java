package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {
    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    WebDriver driver;

    @Before
   public void befor(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

   }
   @After
    public void after(){
        driver.quit();

    }
    @Test
    public void assertionTest() {
        driver.get("https://www.amazon.com");
        String currenturl = driver.getCurrentUrl();
        System.out.println("currenturl = " + currenturl);

        // URL amazon kelimesi iceriyor mu kontrol saglanıyor..
        Assert.assertTrue(currenturl.contains("amazon"));

    }
    @Test
    public void titleTest(){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook"));

    }
}
