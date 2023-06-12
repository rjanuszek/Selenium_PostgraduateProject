package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PagesObjects.BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-count")
    WebElement searchResult;

    public boolean checkSearchResult(String text) {
        boolean searchResultText = searchResult.getText().contains(text);
        return searchResultText;
    }
}