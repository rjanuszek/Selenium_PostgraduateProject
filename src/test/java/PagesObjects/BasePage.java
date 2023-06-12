package PagesObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;
    protected Faker faker;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        faker = new Faker();
    }

    protected boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public String isTextInRedAlertBox(WebElement box) {
        return box.getText();
    }
}