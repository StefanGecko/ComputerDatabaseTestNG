package pages;

import common.elementActions.Button;
import common.elementActions.Input;
import common.elementActions.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Page instances for actions that are going to be used.
     */
    public Button button = new Button(driver, wait);
    public Validate validate = new Validate(driver, wait);
    public Input input = new Input(driver, wait);


    /**
     * Web element locators
     */
    By pageTitle = By.className("fill");
    By mainTable = By.className("computers");



    /**
     * Page Methods
     */

    public void validateHomePage(){
        validate.textContains(pageTitle, "Computer database");
        validate.isElementPresent(mainTable);
    }

}
