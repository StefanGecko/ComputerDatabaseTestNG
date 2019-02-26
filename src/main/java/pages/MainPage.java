package pages;

import utilities.PropertiesFile;
import common.elementActions.Button;
import common.elementActions.Input;
import common.elementActions.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {


    //*********Constructor*********
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Test data from properties file.
     */
    PropertiesFile properties = new PropertiesFile();
    String invalidIntroducedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_INTRODUCED_DATE);
    String invalidDiscontinuedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_DISCONTINUED_DATE);
    String computerName = properties.getPropertyValue(PropertiesFile.PropertyKey.LENOVO_COMPUTER_NAME);

    /**
     * Page instances for actions that are going to be used.
     */
    public Button button = new Button(driver, wait);
    public Validate validate = new Validate(driver, wait);
    public Input input = new Input(driver, wait);

    /**
     * Web Elements
     */
    private By filterCompName = By.id("searchbox");
    private By filterBtn = By.id("searchsubmit");
    private By filteredComp = By.cssSelector(".computers > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(1)");
    private By addNewCompButton = By.id("add");
    private By addConfirmation = By.className("alert-message");
    private By introducedColumn = By.cssSelector(".computers > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)");
    private By discontinuedColumn = By.cssSelector(".computers > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)");
    private By blankNamefield = By.className("help-inline");


    /**
     * Page methods
     */
    public void filterByComputerName(){

        input.clear(filterCompName);
        input.type(filterCompName,"Lenovo X1 ThinkPad Carbon 3rd Generation");
        button.click(filterBtn);
        validate.isElementPresent(filteredComp);
        validate.textEquals(filteredComp,computerName);
    }

    public void addNewComputer(){
        validate.isElementPresent(addNewCompButton);
        button.click(addNewCompButton);

    }

    public void addNewComputerValidation(){
        validate.isElementPresent(addConfirmation);
        validate.textContains(addConfirmation,"has been created");

    }

    public void accessComputer(){
        input.clear(filterCompName);
        input.type(filterCompName,"Dell Inspiron");
        button.click(filterBtn);
        validate.isElementPresent(filteredComp);
        button.click(filteredComp);
    }

    public void invalidDateValidation(){
        input.clear(filterCompName);
        input.type(filterCompName,"Dell Inspiron 15");
        button.click(filterBtn);
        validate.isElementPresent(filteredComp);
        validate.textEquals(introducedColumn,invalidIntroducedDate);
        validate.textEquals(discontinuedColumn,invalidDiscontinuedDate);
    }

    public void blankNameValidation(){
        validate.textEquals(blankNamefield, "Required") ;
    }
}
