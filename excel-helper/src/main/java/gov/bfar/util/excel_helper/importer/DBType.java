package gov.bfar.util.excel_helper.importer;

public enum DBType {
                    MySQL("mysql");

    private String name;

    private DBType(String name) {
        this.name = name;
    }

    public static DBType instantiateByName(String name) {
        for (DBType type : DBType.values()) {
            if (type.getName().equals(name))
                return type;

        }
        throw new DBTypeNotSupportedException("Database Type : " + name + " is not supported. Please refer to docs for supported Databases.");
    }

    public String getName() {
        return name;
    }

}
