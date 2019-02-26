package tests;

import org.testng.annotations.Test;
import pages.AddPage;
import pages.HomePage;
import pages.MainPage;
import utils.ExtentReports.ExtentTestManager;

public class CreateComputerTests extends BaseTest {

    //*************Test Methods*************
    @Test(description = "TC: 03 - Validate if a single computer can be added in the computer database web application.")
    public void addSingleComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 03 - Validate if a single computer can be added in the computer database web application.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        MainPage mainPage = new MainPage(driver, wait);
        AddPage addPage = new AddPage(driver, wait);

        //*************PAGE METHODS ********************
        //Open Computer Database page
        homePage.validateHomePage();
        mainPage.addNewComputer();
        addPage.createNewComputer();
        mainPage.addNewComputerValidation();

    }

    @Test(description = "TC: 04 - Validate if a single computer can be added in the computer database web application with special characters in the name.")
    public void addSingleComputerInvalidNameFormatTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 04 - Validate if a single computer can be added in the computer database web application with special characters in the name.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        MainPage mainPage = new MainPage(driver, wait);
        AddPage addPage = new AddPage(driver, wait);

        //*************PAGE METHODS ********************
        //Open Computer Database page
        homePage.validateHomePage();
        mainPage.addNewComputer();
        addPage.createNewComputerInvalidName();
        mainPage.addNewComputerValidation();

    }

    @Test(description = "TC: 05 - Validate if new computer can be added to the computer database when the year is set to 0000 as introduced date and 9999 as discounted date.")
    public void addSingleComputerInvalidDateTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 05 - Validate if new computer can be added to the computer database when the year is set to 0000 as introduced date and 9999 as discounted date.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        MainPage mainPage = new MainPage(driver, wait);
        AddPage addPage = new AddPage(driver, wait);

        //*************PAGE METHODS ********************
        //Open Computer Database page
        homePage.validateHomePage();
        mainPage.addNewComputer();
        addPage.createNewComputerInvalidDate();
        mainPage.invalidDateValidation();

    }

    @Test(description = "TC: 07 - Validate if new computer can be added to the computer database with the same name as an existing computer.")
    public void addSameNameComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 07 - Validate if new computer can be added to the computer database with the same name as an existing computer.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        MainPage mainPage = new MainPage(driver, wait);
        AddPage addPage = new AddPage(driver, wait);

        //*************PAGE METHODS ********************
        //Open Computer Database page
        homePage.validateHomePage();
        mainPage.addNewComputer();
        addPage.createNewComputer();
        mainPage.addNewComputerValidation();

    }

    @Test(description = "TC: 08 - Validate if new computer can be added to the computer database when computer name field is blank.")
    public void addSingleComputerTestBlankName() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 08 - Validate if new computer can be added to the computer database when computer name field is blank.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        MainPage mainPage = new MainPage(driver, wait);
        AddPage addPage = new AddPage(driver, wait);

        //*************PAGE METHODS ********************
        //Open Computer Database page
        homePage.validateHomePage();
        mainPage.addNewComputer();
        addPage.createNewComputerBlankName();
        mainPage.blankNameValidation();

    }

}
