package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends PagesObjects.BasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Women")
    WebElement womenLink;

    public void clinkOnWomenLink() {
        womenLink.click();
    }
}