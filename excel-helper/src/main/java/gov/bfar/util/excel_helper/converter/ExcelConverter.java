package gov.bfar.util.excel_helper.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConverter implements Converter {

    private File sourceFile;
    private File outputFile;

    public ExcelConverter(File sourceFile, File outputFile) {
        this.sourceFile = sourceFile;
        this.outputFile = outputFile;
    }

    @Override
    public void toJson() throws FileNotFoundException, IOException {
        
        try (XSSFWorkbook workbook = new XSSFWorkbook(sourceFile)) {
            System.out.println(workbook.getNumberOfSheets());
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException, OpenXML4JException {
        //Converter converter = new ExcelConverter(new File("F:/RSBSA/RSBSA 1.1/RSBSA ver 1.1.xlsx"), null);
        //converter.toJson();
        /*OPCPackage pkg = OPCPackage.open(new File("C:/Users/Kmacalalag/Documents/rsbsa/da sheet/first 26000.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(pkg);
        SXSSFWorkbook wb = new SXSSFWorkbook(workbook, 100);
        System.out.println(wb.getNumberOfSheets());*/
        
        File folder = new File("C:/Users/Kmacalalag/Documents/rsbsa/da sheet");
        File[] files = folder.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        
        
    }
}
