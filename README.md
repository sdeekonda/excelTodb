excelTodb
=========

Java library for creating database tables from Excel files

Usage example: 

1. Default settings

public class LibraryTest {
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
}


2. Settings with custom types for Excel cells

public class LibraryTest {
    public static void main(String args[ ])
    {

        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbname";
        String DB_USER = "root";
        String DB_PASSWORD = "password";
        String DB_TABLE_NAME = "table_test";
        ExcelToDB excelToDB = new ExcelToDB(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD, DB_TABLE_NAME);
        Map<Integer, String> annotation = new HashMap<Integer, String>();
        //number of column and it's type
        annotation.put(6, "text");
        annotation.put(7, "text");
        excelToDB.start("D:\\Idea Projects\\librarytest\\test.xls", annotation);
     
    }
}
