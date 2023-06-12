package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenuPage extends PagesObjects.BasePage {

    public SubMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_query_top.search_query.form-control.ac_input")
    WebElement searchObject;

    @FindBy(name = "submit_search")
    WebElement searchObjectButton;

    public void inputTextInSearchObject(String text) {
        searchObject.sendKeys(text);
    }

    public void clickSearchObjectLink() {
        searchObjectButton.click();
    }
}