package org.nageena.Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    static Workbook wb;
    static Sheet sh;
    public static String file_path = System.getProperty("user.dir") + "/src/test/java/org/nageena/SeleniumTests/Test.xlsx";

    public static Object[] getexceldata(String sheetName) throws IOException {
        // Opening file
        FileInputStream file = null;
        try{
            file = new FileInputStream(file_path);
            System.out.println(file_path);
            }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        wb = WorkbookFactory.create(file);
        sh = wb.getSheet(sheetName);

        Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
        for (int i = 0; i <sh.getLastRowNum() ; i++) {
            for (int j = 0; j <sh.getRow(0).getLastCellNum() ; j++) { // neglecting first row as it is header
                data [i][j] = sh.getRow(i+1).getCell(j).toString();

            }

        }
        return data;
    }



    @DataProvider(parallel = false)

    public Object[] getdata() throws IOException {
        return getexceldata("Sheet1");

    }
}
