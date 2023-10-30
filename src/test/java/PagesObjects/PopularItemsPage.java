package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopularItemsPage extends BasePage {

    public PopularItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#homefeatured .alert.alert-info")
    WebElement textPopularItems;

    public String isTextAvailableForPopularItems() {
        return isTextInBlueBox(textPopularItems);
    }
}