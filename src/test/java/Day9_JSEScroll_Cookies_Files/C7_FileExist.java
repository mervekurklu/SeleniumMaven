package Day9_JSEScroll_Cookies_Files;

import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7_FileExist extends BaseTest {

    /*
Selenium ile windows uygulamalarını test edemiyoruz.
Ama test etmek için JAVA kullanabiliriz.
Bilgisayarımızda bir dosya olup olmadığını(exist) kontrol
etmek için Java'yı kullanabiliriz

System.getProperty ("user.dir"); İçinde bulunulan
klasörün yolunu (path) verir.
System.getProperty ("user.home"); Bilgisayarımızda
bulunan user klasörünü verir.
Files.exists (Paths.get (filePath)); Bilgisayarınızda
dosyanın olup olmadığını kontrol eder
upload=yüklemek
 */

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));//projemizin rootunun yolunu verir.
        String projectRoot=System.getProperty("user.dir");//bulmak istediğimiz file proje içerisinde oldugundan proje yolunu aldık
        String filePath="/src/test/java/resources/F51EEEFC-E9CA-4CE8-A13C-2B744FD104CF.jpeg";
        filePath=projectRoot+filePath;//burda bir dosyamız olduğu için true döner.

        System.out.println(Files.exists(Paths.get(filePath)));//String olan yolumuzu path yoluna çeviriyor.

        if (Files.exists(Paths.get(filePath))){
            System.out.println("Dosya Bulundu");
        }else System.out.println("Dosya Bulunamadı");

    }



/*

        //System.out.println(System.getProperty("user.dir"));
        //String projeYolu=System.getProperty("user.dir");
        String cwJunitFileexistKadar="/Users/apple-pc/IdeaProjects/CWJunitSelenium/src/test/java/resources/D93CD509-6097-43EA-BEE7-D8D886A990BF.png";
        //String dosyayaKadarOlanYol= projeYolu+cwJunitFileexistKadar;
        System.out.println(Files.exists(Paths.get(cwJunitFileexistKadar)));
        if (Files.exists(Paths.get(cwJunitFileexistKadar))){
            System.out.println("var");

        }else System.out.println("yok");

 */


    }

