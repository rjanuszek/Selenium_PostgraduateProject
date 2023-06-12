package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PagesObjects.BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailAddress;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccount;

    @FindBy(id = "create_account_error")
    WebElement redAlertBox;


    public void inputRandomEmailAddress() {
        String email = faker.internet().emailAddress();
        emailAddress.sendKeys(email);
    }

    public void inputSpecificEmailAddress(String text) {
        emailAddress.sendKeys(text);
    }

    public void createAnAccount() {
        createAnAccount.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(redAlertBox);
    }

    public String redBoxText() {
        return isTextInRedAlertBox(redAlertBox);
    }
}