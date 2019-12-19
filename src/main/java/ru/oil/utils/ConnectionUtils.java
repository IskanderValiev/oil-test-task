package ru.oil.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static ru.oil.utils.PropertiesFileReader.*;

/**
 * @author Iskander Valiev
 * created by isko
 * on 12/19/19
 */
public class ConnectionUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Properties properties = getProperties();
        String driver = properties.getProperty("datasource.driver");
        Class.forName(driver);

        String url = properties.getProperty("datasource.db_url");
        String user = properties.getProperty("datasource.db_user");
        String password = properties.getProperty("datasource.db_password");
        return DriverManager.getConnection(url, user, password);
    }

}
