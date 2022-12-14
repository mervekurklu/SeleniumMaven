package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    // Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.
    public static void main(String[] args) {
        //System.setproperty yerine geçti
        WebDriverManager.chromedriver().setup();
        //Driver obj oluşturduk
        WebDriver driver=new ChromeDriver();

        //maksimize ettik
        driver.manage().window().maximize();
        //Google anasayfamızı açtık
        driver.get("https://www.google.com");
        //title imizi aldık ve yazdırdık
        String pagetitle=driver.getTitle();
        System.out.println("pagetitle = " + pagetitle);

        if (pagetitle.equalsIgnoreCase("Google")){
            System.out.println("test passed");
        }else System.out.println("test failed");

        driver.close();



    }
}
