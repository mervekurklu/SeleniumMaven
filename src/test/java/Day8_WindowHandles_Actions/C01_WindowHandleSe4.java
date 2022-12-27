package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {

    // https://testproject.io/

// https://blog.testproject.io/


    @Override
    public void tearDown() {

    }

    @Test
    public void newWindow(){
        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW);// driverde yeni bir pencere oluşturduk zaten yeni oluşturulan kısmı point ettş yeni Web driver gerek yok
        driver.get("https://blog.testproject.io/");
        //driver.switchTo().newWindow(WindowType.WINDOW).get("https://blog.testproject.io/");
    }
    @Test
    public  void newTab(){
        driver.get("https://testproject.io/");
        // yeni bir sekme oluşturuldu..
        WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
        // yeni sekmede amazona gidildi
        newTab.get("https://www.amazon.com");// üstetki gibi yazmak daha best. newtab aynı driver olduğu için yeniden Web dememize gerek yok
        // yeni oluşturulan tabın tittle yazdırıldı
        System.out.println(driver.getTitle());
    }
    @Test
    public void handleWindows(){
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.TAB);// yeni sekme açıldı

        //yeni sekmemizde amazon tr yi açtık
        driver.get("https://www.amazon.com.tr/");

        driver.switchTo().newWindow(WindowType.WINDOW);// yeni bir pencere oluşturduk

        driver.get("https://www.google.com");// yeni bir pencere de google açtık

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();// set üzerinde gezinmek için ıterator kullandık

        while (i.hasNext()){//gezinme işlemi burada oluyor
            String currentTab = i.next();
            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());
            if (!driver.getTitle().contains("Spend")){
                driver.close();
            }

        }
        /*
        if(!driver.getWindowHandle().equals(homepageHandle)){

           driver.close();
        }
         */
             //2. yol




    }

}
