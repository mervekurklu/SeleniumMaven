package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends BaseTest {



//    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page.
//    Set the driver back to the main page.



    @Test
    public void windowHandles(){
        /*
Herhangi bir tarayıcıdaki bir window, kullanıcının bir bağlantıya/URL'ye tıkladıktan sonra geldiği ana web
sayfasıdır.
Bir kullanıcı bir URL'ye ulaştığında bir web sayfası açılır. Bu ana sayfa, ana penceredir (parent window),
yani kullanıcının şu anda açtığı ve herhangi bir işlemi gerçekleştireceği ana penceredir.
​
 Methodları şunladır:
 1-driver.getWindowHandle();→ Mevcut sayfanın window handle değerini alır.
 2-driver.switchTo().window(switch);→ Window handle değerini kullanarak pencereler arası geçiş yapar.
 3-driver.switchTo().newWindow(WindowType.TAB);→ Yeni TAB oluşturarak geçiş yapar.
 4-driver.switchTo().newWindow(WindowType.WINDOW)→ Yeni WINDOW oluşturarak geçiş yapar.
 5-driver.getWindowHandles()→ Tüm sayfaların window handle değerini alır
 6-if (!mainWindow.equalsIgnoreCase(ChildWindow)): Parent window ile child window karşılaştırılır.
 7-Set <String> s = driver.getWindowHandles(): Tüm child window’ları String data type’ta bir sete atar.
 8-Iterator <String> itr = s.iterator(): Burada tüm child window’lar yinelenir.
 */

        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");


        //Daha sonra kullanabilmek adina ana sayfa id mizi sakliyoruz
        String homePageId = driver.getWindowHandle();


        // Yeni sekmeler olusturmak adina target = _blank olan linklerden 2 tanesine tikliyoruz
        List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));

        links.get(0).click();
        links.get(1).click();


        //Iterate etmek icin (gezinmek icin) tum tab ve window id lerini bir set icinde sakliyoruz
        Set<String> windows = driver.getWindowHandles();

        //Gezinme islemi icin iterator objesini olusturuyoruz
        Iterator<String> iterator = windows.iterator();

        //Gezinme islemi
        while (iterator.hasNext()){

            //Her bir gezinilen id kullanilarak o anki sekmeye switch ediyoruz
            driver.switchTo().window(iterator.next());

            //Switch ettigimiz sayfanin ana sayfa olup olamdigini kontrol ediyoruz. Ana sayfa ise sekmeyi kapatmiyoruz degilse kapatiyoruz
            if(driver.getWindowHandle().equals(homePageId)){

                //driver.close u es geciyoruz
                continue;
            }

            //Sekmeyi kapatiyoruz 
            driver.close();

            }
        }

    }