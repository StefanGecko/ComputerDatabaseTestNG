package tests;

import org.testng.annotations.Test;
import pages.EditPage;
import pages.MainPage;
import utils.ExtentReports.ExtentTestManager;

public class EditComputerTests extends BaseTest {


    @Test(description = "TC: 10 - Validate if existing computer can be edited in the computer database.")
    public void editComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 10 - Validate if existing computer can be edited in the computer database.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);
        EditPage editPage = new EditPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Computer Database page
        mainPage.accessComputer();
        editPage.editComputerDates();
        mainPage.filterByComputerName();


    }

    @Test(description = "TC: 11 - Validate if existing computer can be edited in the computer database with invalid date format.")
    public void editComputerInvalidDateTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 11 - Validate if existing computer can be edited in the computer database with invalid date format.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);
        EditPage editPage = new EditPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Computer Database page
        mainPage.accessComputer();
        editPage.editComputerInvalidDate();

    }



    @Test(description = "TC: 13 - Validate if cancel button is pressed on edit page no changes occur to the previously added computer.")
    public void cancelEditComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 13 - Validate if cancel button is pressed on edit page no changes occur to the previously added computer.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);
        EditPage editPage = new EditPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Computer Database page
        mainPage.accessComputer();
        editPage.cancelEditComputer();

    }

    @Test(description = "TC: 14 - Validate if the computer name can be removed from an existing computer in the computer database.")
    public void editComputerInvalidBlankName() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 14 - Validate if the computer name can be removed from an existing computer in the computer database.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);
        EditPage editPage = new EditPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Computer Database page
        mainPage.accessComputer();
        editPage.editComputerBlankComputerName();

    }

}
