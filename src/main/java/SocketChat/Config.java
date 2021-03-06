package SocketChat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "src/main/resources/config.properties";

    public static int PORT;
    public static String HOST;
    public static String HELLO_MESSAGE;
    public static int HISTORY_LENGTH;

    static {
        Properties properties = new Properties();

        try(FileInputStream propertiesFile = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(propertiesFile);
            PORT           = Integer.parseInt(properties.getProperty("PORT"));
            HOST           = properties.getProperty("HOST");
            HELLO_MESSAGE  = properties.getProperty("HELLO_MESSAGE");
            HISTORY_LENGTH = Integer.parseInt(properties.getProperty("HISTORY_LENGTH"));

        } catch (FileNotFoundException e) {
            System.err.println("Properties config file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error while reading file");
            e.printStackTrace();
        }
    }

}
