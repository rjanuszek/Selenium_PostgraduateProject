package PagesObjects;

import Model.DataForTest;
import Model.DataForLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends PagesObjects.BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement mrGenderRadio;

    @FindBy(id = "id_gender2")
    WebElement mrsGenderRadio;

    @FindBy(css = "#customer_firstname")
    WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "days")
    WebElement dayOfBirthList;

    @FindBy(id = "months")
    WebElement monthOfBirthList;

    @FindBy(id = "years")
    WebElement yearOfBirthList;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

//    @FindBy(id = "optin")
//    WebElement specialOffersCheckBox;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public void chooseMrTitle() {
        mrGenderRadio.click();
    }

    public void chooseMrsTitle() {
        mrsGenderRadio.click();
    }

    public void clickNewsletterCheckbox() {
        newsletterCheckbox.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void inputDataInLoginForm(DataForLogin message) {
        firstNameInput.sendKeys(message.getFirstName());
        lastNameInput.sendKeys(message.getLastName());
        passwordInput.sendKeys(message.getPassword());

        Select day = new Select(this.dayOfBirthList);
        day.selectByIndex(DataForTest.DAY_OF_BIRTH);

        Select month = new Select(this.monthOfBirthList);
        month.selectByValue(DataForTest.MONTH_OF_BIRTH);

        Select year = new Select(this.yearOfBirthList);
        year.selectByValue(DataForTest.YEAR_OF_BIRTH);
    }
}