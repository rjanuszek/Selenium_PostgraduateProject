package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "info-account")
    WebElement textWelcomeAccount;

    public String isTextAvailableWhenAccountRegister() {
        return isTextInRedAlertBox(textWelcomeAccount);
    }
}