package ru.oil.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Iskander Valiev
 * created by isko
 * on 12/19/19
 */
public class PropertiesFileReader {

    private static Logger logger = Logger.getLogger(PropertiesFileReader.class);

    public static Properties getProperties() {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("/Users/isko/Desktop/Work/Oil_Test_Task/oiltesttask/src/main/resources/application.properties")){
            properties.load(fis);
            return properties;
        } catch (FileNotFoundException ex) {
            logger.error("File not found exception has been occurred");
        } catch (IOException e) {
            logger.error("IOException has been occurred: " + e.getMessage());
        }
        return null;
    }
}
