package org.krylov.lib;

import org.krylov.lib.InsertToDB;
import org.krylov.lib.ReadXls;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: krylov
 * Date: 29.05.13
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class ExcelToDB {
    private List<LinkedHashMap> xlsData;
    private Map<Integer,Integer> columnLength;

    public Map<Integer, String> getColumn_names() {
        return column_names;
    }

    public void setColumn_names(Map<Integer, String> column_names) {
        this.column_names = column_names;
    }

    private Map<Integer,String> column_names;


    private Properties dbconf = new Properties();

    public ExcelToDB(String db_driver, String db_conn, String db_user, String db_password, String tableName){
        setDriver(db_driver);
        setConnection(db_conn);
        setUser(db_user);
        setDBPassword(db_password);
        setTableName(tableName);
    }

    //Name of the used driver
     public void setDriver (String myDriver){
          dbconf.put("Driver", myDriver);
     }
    // Db connection
    public void setConnection (String myConnection){
        dbconf.put("Connection", myConnection);
    }
    //db user
    public void setUser (String myUser){
        dbconf.put("User", myUser);
    }
    //db password
    public void setDBPassword (String myPassword){
        dbconf.put("Password", myPassword);
    }
    //Excel file to parce
    public void setXLSFile (String xlsFile){
        dbconf.put("File", xlsFile);
    }
    //set table name to insert data to
    public void setTableName (String tableName){
        dbconf.put("TableName", tableName);
    }
    //start to parce Excel and insert to db
    public void start(String file){
        ReadXls readXls = new ReadXls(file);
        xlsData=readXls.getResult();
        columnLength=readXls.getColumnLength();
        InsertToDB insertToDB = new InsertToDB(dbconf, xlsData, columnLength);
        if (getColumn_names()==null){
        insertToDB.start();
        }
        else {
            insertToDB.start(getColumn_names());
        }
    }
    public void start(String file, Map<Integer, String>annotations){
        ReadXls readXls = new ReadXls(file, annotations);
        xlsData=readXls.getResult();
        columnLength=readXls.getColumnLength();
        InsertToDB insertToDB = new InsertToDB(dbconf, xlsData, columnLength);
        if (getColumn_names()==null){
            insertToDB.start();
        }
        else {
            insertToDB.start(getColumn_names());
        }
    }
}
