package testsWithShaft;

import com.shaft.driver.SHAFT;
import org.testng.annotations.*;
import pages.homePage;
import pages.userInformationPage;
import pages.newUserSignUp;


public class signUp {
    private SHAFT.GUI.WebDriver driver;

    private homePage HomePage;

    private newUserSignUp newUserSignUpObject;

    private userInformationPage userInformationObject;

    SHAFT.TestData.JSON testData;



    @Test
    public void test() {
        HomePage.assertOnVisibilityOfHomePage("FEATURES ITEMS");
        HomePage.SignUp();
        newUserSignUpObject.assertOnSignUpPage("New User Signup!");
        newUserSignUpObject.UserSignUp(testData.getTestData("testDataUserName"),testData.getTestData("testDataUserMail")+System.currentTimeMillis()+"@gizasystems.com");
        userInformationObject.assertOnAccountInfoPage("ENTER ACCOUNT INFORMATION");
        userInformationObject.enterAccountInformation(testData.getTestData("testDataUserPassword"),testData.getTestData("testDataUserFirstName"),
                testData.getTestData("testDataUserLastName"), testData.getTestData("testDataUserBirthDay"),
                testData.getTestData("testDataUserBirthMonth"), testData.getTestData("testDataUserBirthYear"));
        userInformationObject.enterAddressInformation(testData.getTestData("testDataUserAddress1"),testData.getTestData("testDataUserAddress2"),
                testData.getTestData("testDataUserCountry") ,testData.getTestData("testDataUserState"),
                testData.getTestData("testDataUserCity"),testData.getTestData("testDataUserZipCode"),testData.getTestData("testDataUserMobile"));
        userInformationObject.assertOnAccountCreated("ACCOUNT CREATED!");//

    }



        @BeforeClass
    public void beforeClass() {
            driver = new SHAFT.GUI.WebDriver();
            HomePage = new homePage(driver);
            HomePage.navigateToHomePage();
            newUserSignUpObject = new newUserSignUp(driver);
            userInformationObject = new userInformationPage(driver);
            testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData.json");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){

        driver.quit();
    }

}
