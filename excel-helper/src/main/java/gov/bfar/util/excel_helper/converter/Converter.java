package gov.bfar.util.excel_helper.converter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Converter {

    void toJson() throws FileNotFoundException, IOException;

}
