package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class homePage {

    SHAFT.GUI.WebDriver driver;
    String homePageUrl = "https://automationexercise.com/";

    private final By homePageTitle = By.xpath("(//h2[@class='title text-center'])[1]");
    private final By selectSignUpIcon  = By.xpath("(//a//i)[4]");


    public homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToHomePage() {

        driver.browser().navigateToURL(homePageUrl);
    }

    public void assertOnVisibilityOfHomePage(String expectedResult) {
        driver.element().getText(homePageTitle);
        driver.assertThat().element(homePageTitle).text().isEqualTo(expectedResult).perform();

    }

    public void SignUp () {

        driver.element().click(selectSignUpIcon);
    }

}




