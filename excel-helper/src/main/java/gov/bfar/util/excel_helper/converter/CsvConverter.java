package gov.bfar.util.excel_helper.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

import com.opencsv.CSVReader;

public class CsvConverter implements Converter {

    private File sourceFile;

    private File outputFile;

    public CsvConverter(File sourceFile, File outputFile) {
        this.sourceFile = sourceFile;
        this.outputFile = outputFile;
    }

    public void toJson() throws FileNotFoundException, IOException {
        System.out.println("Converting start");
        JsonFactory jsonFactory = new JsonFactory();
        try (CSVReader reader = new CSVReader(new FileReader(sourceFile));
                JsonGenerator gen = jsonFactory.createJsonGenerator(outputFile, JsonEncoding.UTF8).useDefaultPrettyPrinter();) {
            String[] fieldName = reader.readNext();
            String[] line;
            gen.writeStartArray();
            while ((line = reader.readNext()) != null) {
                System.out.println(".");
                gen.writeStartObject();
                for (int col = 0; col < line.length - 1; col++) {
                    gen.writeStringField(fieldName[col], line[col]);
                }
                gen.writeEndObject();
            }
            gen.writeEndArray();
        }
        System.out.println("end");
    }
}
