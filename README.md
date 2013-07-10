excelTodb
=========

Java library for creating database tables from Excel files

Usage example: 

1. Default settings

    public static void main(String args[ ])
    {

        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbname";
        String DB_USER = "root";
        String DB_PASSWORD = "password";
        String DB_TABLE_NAME = "table_test";
        ExcelToDB excelToDB = new ExcelToDB(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD, DB_TABLE_NAME);
        excelToDB.start("D:\\Idea Projects\\librarytest\\test.xls");
        
    }



2. Settings with custom types for Excel cells

    public static void main(String args[ ])
    {

        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbname";
        String DB_USER = "root";
        String DB_PASSWORD = "password";
        String DB_TABLE_NAME = "table_test";
        ExcelToDB excelToDB = new ExcelToDB(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD, DB_TABLE_NAME);
        Map<Integer, String> annotation = new HashMap<Integer, String>();
        /*number of column and it's type
          now we can use three types: "text", "numeric", "date"
        */
        annotation.put(6, "text");
        annotation.put(7, "text");
        excelToDB.start("D:\\Idea Projects\\librarytest\\test.xls", annotation);
     
    }


3. Settings with custom names for Excel cells

   
         public static void main(String args[ ])
    {

         String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbname";
        String DB_USER = "root";
        String DB_PASSWORD = "password";
        String DB_TABLE_NAME = "table_test";
        ExcelToDB excelToDB = new ExcelToDB(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD, DB_TABLE_NAME);
        Map<Integer, String> column_names = new HashMap<Integer, String>();
        // setting name for the first column
        column_names.put(1, "test1");
        // setting name for the forth column
         column_names.put(4, "test4");
        excelToDB.setColumn_names(column_names);
        excelToDB.start("D:\\Idea Projects\\librarytest\\test.xls");
        
    }
     
  

