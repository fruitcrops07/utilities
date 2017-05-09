package gov.bfar.util.excel_helper.importer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class ExcelImporter implements Importer {

    private File sourceFile;

    private File propertyFile;

    private Properties properties = new Properties();
    
    private Handle handle;
    private DBI dbi;
    
    public ExcelImporter(File sourceFile, File propertyFile) {
        this.sourceFile = sourceFile;
        this.propertyFile = propertyFile;
    }

    @Override
    public void toDB() throws FileNotFoundException, IOException {
        properties.load(new FileInputStream(propertyFile));
        initializeDbConfig(properties);

    }

    private void initializeDbConfig(Properties dbConfig) {
        String db = dbConfig.getProperty("db");
        String ip = dbConfig.getProperty("ip");
        String port = dbConfig.getProperty("port");
        String user = dbConfig.getProperty("user");
        String password = dbConfig.getProperty("password");
        String type = dbConfig.getProperty("type");
        dbi = new DBI(String.format("jdbc:%s://%s:%s/%s", DBType.instantiateByName(type).getName(), ip, port, db), user, password);
        handle = dbi.open();
        handle.execute("create table sample (id int primary key, fullname varchar(255))");
        handle.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Importer importer = new ExcelImporter(null, new File("c://Users/Kmacalalag/dbconfig.properties"));
        importer.toDB();

    }

}
