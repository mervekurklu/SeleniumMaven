package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_FileExists {

    @Test
    public void fileExists() {
     //   /Users/apple-pc/IdeaProjects/CWJunitSelenium/src/test/java/resources/D93CD509-6097-43EA-BEE7-D8D886A990BF.png

        System.out.println(System.getProperty("user.home"));
       String homePath=System.getProperty("user.home");
        String filePath="/Desktop/fileExist.png";
        String fullPath=homePath+filePath;
        System.out.println(Files.exists(Paths.get(fullPath)));
        File image=new File(fullPath);
        Assert.assertTrue(image.exists());
    }
}
