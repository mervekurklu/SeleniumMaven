package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/resources/excelfile.xlsx";//excell dosyamıızn path ini aldık

        FileInputStream fileInputStream=new FileInputStream(path);//dosyamızı açtık
        Workbook workbook= WorkbookFactory.create(fileInputStream);//açtığımız dosyayı excell worlbookuna cevirdik
        Sheet sheet=workbook.getSheetAt(0);//ilk sayfamızı açmış olduk worbook tan sheete geçiş yaptık
        Row row1=sheet.getRow(0);// elimizde satırımozda var datalara geçicez bundan sonra
        Cell cell1= row1.getCell(0);//ilk hücremizi aldık
        System.out.println("Cell1 : "+cell1.toString().toLowerCase());// üzerinde işlem yapıxaksak to string yazmamızda fayda var

    }
}
