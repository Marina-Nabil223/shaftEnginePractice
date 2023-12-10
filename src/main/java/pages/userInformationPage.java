package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class userInformationPage {

    SHAFT.GUI.WebDriver driver;

    private final By accountInfoTxt = By.xpath("(//h2[@class='title text-center']//b)[1]");
    private final By gender = By.id("id_gender2");
    private final By password =  By.id("password");
    private final By days =  By.id("days");
    private final By months =  By.id("months");
    private final By years =  By.id("years");
    private final By newsletter =  By.id("newsletter");
    private final By optin =  By.id("optin");
    private final By firstName =  By.id("first_name");
    private final By LastName =  By.id("last_name");
    private final By addressOne =  By.id("address1");
    private final By addressTwo =  By.id("address2");
    private final By country =  By.id("country");
    private final By state =  By.id("state");
    private final By city = By.id("city");
    private final By zipcode =  By.id("zipcode");
    private final By mobileNumber =  By.id("mobile_number");
    private final By createAccountBtn =  By.xpath("//button[@data-qa=\"create-account\"]");
    private final By createAccountMsg = By.xpath("//h2[@data-qa=\"account-created\"]//b");

    public userInformationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void assertOnAccountInfoPage(String expectedResult)
    {
        driver.element().getText(accountInfoTxt);
        driver.assertThat().element(accountInfoTxt).text().isEqualTo(expectedResult).perform();

    }

    public void enterAccountInformation(String pass,String userFirstName,String userLastName,String day,String month,String year) {
        driver.element().click(gender);
        driver.element().type(password,pass);

        driver.element().select(days,day);
        driver.element().select(months,month);
        driver.element().select(years,year);

        driver.element().click(newsletter);
        driver.element().click(optin);

        driver.element().type(firstName,userFirstName);
        driver.element().type(LastName,userLastName);
    }
    public void enterAddressInformation(String userAddressOne,String userAddressTwo,String Country,String State, String City , String zipCode, String userMobileNumber)
    {
        driver.element().type(addressOne,userAddressOne);
        driver.element().type(addressTwo,userAddressTwo);
        driver.element().select(country,Country);
        driver.element().type(state,State);
        driver.element().type(city,City);
        driver.element().type(zipcode,zipCode);
        driver.element().type(mobileNumber,userMobileNumber);
        driver.element().click(createAccountBtn);
    }

    public void assertOnAccountCreated(String expectedResult) {
        driver.assertThat().element(createAccountMsg).text().isEqualTo(expectedResult).perform();
        //return driver.element().getText(createAccountMsg);
    }



}
