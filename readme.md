# Computer Database Automation Framework built

Tools used: Intelij IDE, Chrome Browser (execution), Firefox Developer edition for location of elements.


# Description:
This automation framework is build to automate the computer database assignment =.
It follows the Page Object Model pattern and from the project structure you can see that the elementActions(validate,button,dropdown and input) are in a package that is called common under main folder 
and also there is a Pages package present that is used to locate the elements and write the methods that are going to be used in the tests later.
In the test folder we have 2 packages that are tests(BasePage that has the setup for starting the tests) and 
Utils(that contains the retry logic if a tests fails upon execution and the Extend Manager classes that are going to be needed for the report.)
The BaseTest class has existing implementation with the web driver manager via maven so the project can be downsized and there is no need to download and import the driver.exe files.

# TestCase coverage in the automation process:
	    1. Adding a computer to the database;
		2. Filtering a computer from the database;
		3. Editing a computer in the computer database;
		4. Cancelling the edit on the computer in the computer database;
		5. Deleting the computer from the computer database;
		6. Edit a computer by deleting the computer name and save.
		7. Test case covering creation of computer with invalid dates as boundary values(0000 and 9999)
		8. Test case covering the input of special chars in the computer name field.
		9. Test case covering creation of computer in the computer database with invalid date format.
		
# Tech
The framework is built with:
	- Maven as build tool
	- Selenium as automation tool
	- TestNG as testing framework tool
	- Extend report as reporting tool
	
# User Guide: 
1. Unzip the project file in a location on your hard drive
2. Start InteliJ IDE and Import project 
3. Click add as a Maven Project.
4. On the right side of the ide select Maven and download sources and documentation.

Once the project is set navigate to the Terminal tab of the InteliJ ide and paste or type in the following command:
mvn clean test -DxmlTestSuite=TestNG.xml

# Report
Once the build has finished in the project structure a folder called ExtentReports will be created and ExtentReportResults.html file will be generated with the test results
Open the html file in browser and review the test results.
Also a generated report will be available in the zip folder.
	