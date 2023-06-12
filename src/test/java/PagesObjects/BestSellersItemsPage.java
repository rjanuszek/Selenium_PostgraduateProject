package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class BestSellersItemsPage extends PagesObjects.BasePage {

    public BestSellersItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "blockbestsellers")
    WebElement buttonBestSellers;

    @FindBy(css = "#blockbestsellers .product-name")
    List<WebElement> productsNamesBestSellers;

    public void clickButtonBestSellers() {
        buttonBestSellers.click();
    }

    public List<String> getProductsNamesBestSellers() {
        return productsNamesBestSellers.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }
}