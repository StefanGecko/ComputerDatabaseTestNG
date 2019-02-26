package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    /**
     * Property file
     */
    private Properties prop = new Properties();

    /**
     * ctor
     */
    public PropertiesFile(){

        try {
            String executionPath = System.getProperty("user.dir");
            System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
            InputStream input = new FileInputStream(executionPath + "/src/test/resources/properties/data.properties");

            prop.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * Get Property value by key
     * @param key
     * @return
     */
    public String getPropertyValue(PropertyKey key){

        return prop.getProperty(key.toString());
    }

    /***
     * Defining PropertyKey
     */
    public enum PropertyKey {

        BROWSER_TYPE("select-browser-type"),
        INVALID_INTRODUCED_DATE("invalid-introduced-date"),
        INVALID_DISCONTINUED_DATE("invalid-discontinued-date"),
        INVALID_DATE_FORMAT("invalid-date-format"),
        LENOVO_COMPUTER_NAME("lenovo-computer-name"),
        DELL_COMPUTER_NAME("dell-computer-name"),
        INVALID_COMPUTER_NAME("invalid-computer-name"),
        EDITED_COMPUTER_NAME("edited-computer-name"),
        TEST_APPLICATION_ENVIRONMENT("test-application-environment-url");

        String value;

        PropertyKey(String value){
            this.value = value;
        }

        public String toString(){
            return value;
        }
    }
}
