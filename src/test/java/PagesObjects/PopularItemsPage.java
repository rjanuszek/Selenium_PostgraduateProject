package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class PopularItemsPage extends PagesObjects.BasePage {

    public PopularItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#homefeatured .product-name")
    List<WebElement> productsNamesPopular;

    public List<String> getProductsNames() {
        return productsNamesPopular.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }
}