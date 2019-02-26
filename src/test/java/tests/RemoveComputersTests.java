package tests;


import org.testng.annotations.Test;
import pages.EditPage;
import pages.MainPage;
import utils.ExtentReports.ExtentTestManager;

public class RemoveComputersTests extends BaseTest{
    @Test(description = "TC: 15 - Validate if computer can be removed from the computer database.")
    public void deleteComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 15 - Validate if computer can be removed from the computer database.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);
        EditPage editPage = new EditPage(driver,wait);

        //*************PAGE METHODS********************
        //Open Computer Database page

            mainPage.accessComputer();
            editPage.deleteComputer();
    }
}
