package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/projintro";
    public static final String USER = "newuser";
    public static final String PASS = "";

    private static final DBConnector instance = new DBConnector();


    public DBConnector() {

    }

    public static DBConnector getInstance(){
        return instance;
    }

    //public static Connection getConnection(){
    //}



}



