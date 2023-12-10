package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class newUserSignUp {

    SHAFT.GUI.WebDriver driver;


    private final By signUpMsg = By.xpath("(//h2)[3]");
    private final By userName =By.name("name");
    private final By userMail =By.xpath("//input[@data-qa='signup-email']");
    private final By signUPBtn =   By.xpath("//button[@data-qa='signup-button']");


    public newUserSignUp(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void assertOnSignUpPage(String expectedResult) {
        driver.element().getText(signUpMsg);
        driver.assertThat().element(signUpMsg).text().isEqualTo(expectedResult).perform();
    }

    public void UserSignUp(String name,String email)
    {
        driver.element().type(userName,name);
        driver.element().type(userMail,email);
        driver.element().click(signUPBtn);
    }


}
