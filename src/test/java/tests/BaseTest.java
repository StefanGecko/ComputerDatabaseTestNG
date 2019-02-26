package tests;

import Utilities.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    private PropertiesFile properties = new PropertiesFile();

    public String baseURL = properties.getPropertyValue(PropertiesFile.PropertyKey.TEST_APPLICATION_ENVIRONMENT);

    @BeforeClass
    public void setup() {


        String browser = properties.getPropertyValue(PropertiesFile.PropertyKey.BROWSER_TYPE);

        if (driver == null) {
            switch (browser) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "OPERA":
                    driver = new OperaDriver();
                    break;

                case "SAFARI":
                    System.setProperty("webdriver.safari.noinstall", "true");
                    driver = new SafariDriver();
                    break;

                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
            }

            wait = new WebDriverWait(driver, 5);
            driver.manage().window().maximize();

            //Navigate to Homepage
            driver.get(baseURL);
        }

    }
        @AfterClass
        public void teardown () {
            driver.quit();

        }


    }

