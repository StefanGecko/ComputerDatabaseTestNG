package pages;

import Utilities.PropertiesFile;
import common.elementActions.Button;
import common.elementActions.Input;
import common.elementActions.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage extends BasePage {


    //*********Constructor*********
    public EditPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //***********Test Data*********
    PropertiesFile properties = new PropertiesFile();
    String invalidDateFormat = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_DATE_FORMAT);
    String invalidIntroducedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_INTRODUCED_DATE);
    String invalidDiscontinuedDate = properties.getPropertyValue(PropertiesFile.PropertyKey.INVALID_DISCONTINUED_DATE);
    String editedComputerName = properties.getPropertyValue(PropertiesFile.PropertyKey.EDITED_COMPUTER_NAME);

    //*************PAGE INSTANTIATIONS*************
    public Button button = new Button(driver, wait);
    public Validate validate = new Validate(driver, wait);
    public Input input = new Input(driver, wait);

    //*********Web Elements*********

    By computerNameInput = By.id("name");
    By introducedDate = By.id("introduced");
    By discontinuitedDate = By.id("discontinued");
    By saveCompButton = By.className("primary");
    By cancelButton = By.linkText("Cancel");
    By deleteCompButton = By.className("danger");
    By deleteConfirmation = By.className("alert-message");
    By introducedColumn = By.cssSelector(".computers > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > em:nth-child(1)");
    By discontinuedColumn = By.cssSelector(".computers > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > em:nth-child(1)");
    By introducedDateAlert = By.className("error");
     By blankNamefield = By.className("help-inline");

    public void editComputerDates(){

        //*********Page Methods*********
        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput,editedComputerName);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        button.click(saveCompButton);
        }



    public void cancelEditComputer(){
        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput,"Lenovo X1 ThinkPad Carbon 3rd Generation");
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        button.click(cancelButton);

    }

    public void deleteComputer(){
        validate.isElementPresent(computerNameInput);
        validate.isElementPresent(introducedDate);
        validate.isElementPresent(discontinuitedDate);
        button.click(deleteCompButton);
        validate.textContains(deleteConfirmation,"Computer has been deleted");
    }

    public void editComputerBlankComputerName(){

        //*********Page Methods*********
        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        button.click(saveCompButton);
        validate.isElementPresent(blankNamefield);
        validate.textEquals(blankNamefield, "Required");
        button.click(cancelButton);

    }

    public void editComputerInvalidDate(){
        validate.isElementPresent(computerNameInput);
        input.clear(computerNameInput);
        input.type(computerNameInput,editedComputerName);
        validate.isElementPresent(introducedDate);
        input.clear(introducedDate);
        input.type(introducedDate,invalidDateFormat);
        validate.isElementPresent(discontinuitedDate);
        input.clear(discontinuitedDate);
        button.click(saveCompButton);
        validate.isElementPresent(introducedDateAlert);
        button.click(cancelButton);
    }

}
