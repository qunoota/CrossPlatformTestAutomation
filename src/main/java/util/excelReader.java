package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
public class excelReader {

    //Finds the number of Excel sheets:
    private static XSSFSheet mSheet;
    public static configReader confReader;

    public void readExcelFile() {
        confReader = new configReader();
        if(mSheet != null) {
            return;
        }
        File src = new File(confReader.getExcelPath());

        try {
            //Read the file and decode the characters
            FileInputStream file = new FileInputStream(src);

            //Read & write Excel sheets, files, and properties
            XSSFWorkbook wb = new XSSFWorkbook(file);
            mSheet = wb.getSheetAt(0);

        } catch(Exception ex) {
            System.out.println("You got: "+ex);
        }
    }

    public String GetCellValue(int row, int column) {
        if (mSheet == null) {
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }
}