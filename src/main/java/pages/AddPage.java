package pages;

import Utilities.PropertiesFile;
import common.elementActions.Button;
import common.elementActions.Dropdown;
import common.elementActions.Input;
import common.elementActions.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPage extends BasePage {


    //*********Constructor*********
    public AddPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //***********Test Data*********
    PropertiesFile properties = new PropertiesFile();
    String invalidDateFormat = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_DATE_FORMAT);
    String invalidIntroducedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_INTRODUCED_DATE);
    String invalidDiscontinuedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_DISCONTINUED_DATE);
    String lenovoComputerName = properties.getPropertyValue(PropertiesFile.PropertyKey.LENOVO_COMPUTER_NAME);
    String dellComputerName = properties.getPropertyValue(PropertiesFile.PropertyKey.DELL_COMPUTER_NAME);
    String invalidComputerName = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_COMPUTER_NAME);



    //*************PAGE INSTANTIATIONS*************
    public Button button = new Button(driver, wait);
    public Validate validate = new Validate(driver, wait);
    public Input input = new Input(driver, wait);
    public Dropdown dropdown = new Dropdown(driver, wait);

    //*********Web Elements*********
    By computerNameInput = By.id("name");
    By introducedDate = By.id("introduced");
    By discontinuitedDate = By.id("discontinued");
    By companyName = By.id("company");
    By createButton = By.className("primary");
    By cancelButton = By.linkText("Cancel");
    By computerNameAlert = By.className("help-inline");

    //*********Page Methods*********
    public void createNewComputer(){

        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput, lenovoComputerName);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        input.type(introducedDate,presentDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        input.type(discontinuitedDate, futureDate());
        dropdown.select(companyName,"Lenovo Group");
        button.click(createButton);

    }


    public void createNewComputerInvalidName(){

        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput,invalidComputerName);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        input.type(introducedDate,presentDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        input.type(discontinuitedDate, futureDate());
        dropdown.select(companyName,"Lenovo Group");
        button.click(createButton);

    }

    public void createNewComputerInvalidDate(){

        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput, dellComputerName);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        input.type(introducedDate,invalidIntroducedDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        input.type(discontinuitedDate, invalidDiscontinuedDate);
        dropdown.select(companyName,"Lenovo Group");
        button.click(createButton);

    }


    public void createNewComputerBlankName(){

        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        input.type(introducedDate,invalidIntroducedDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        input.type(discontinuitedDate, invalidDiscontinuedDate);
        dropdown.select(companyName,"Lenovo Group");
        button.click(createButton);
        validate.textEquals(computerNameAlert,"Required");


    }

}
