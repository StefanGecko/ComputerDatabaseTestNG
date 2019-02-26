package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import utils.ExtentReports.ExtentTestManager;

public class FilterComputerTests extends BaseTest {

    @Test(description = "TC: 18 - Validate if filtering is done by ComputerName.")
    public void filterSingleComputerTest() throws InterruptedException{

        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("TC: 18 - Validate if filtering is done by ComputerName.");

        //*************PAGE INSTANTIATIONS*************
        MainPage mainPage = new MainPage(driver, wait);

        //*************PAGE METHODS********************
        //Open Computer Database page
        mainPage.filterByComputerName();

    }

}
