package gov.bfar.util.excel_helper.importer;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Importer {

    void toDB() throws FileNotFoundException, IOException;
}
