package com.polytechnique.finaltppoo2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Typicaally class to manage database connection if it is used.
 */
public class Database {
    // properties for database connection
    private static final Properties props = new Properties();

    // static initialization of the static attribute props
    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }

    // get the connection with the database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

}
