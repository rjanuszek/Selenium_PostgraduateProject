package PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomenItemsPage extends PagesObjects.BasePage {

    public WomenItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".right-block .product-price")
    List<WebElement> productsPriceWomen;

    @FindBy(css = ".right-block .product-name")
    List<WebElement> productsNameWomen;

    public List<Double> getProductsPriceWomen() {
        return productsPriceWomen.stream()
                .map(el -> el.getText().replace("$", ""))
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public List<String> getProductsNameWomen() {
        return productsNameWomen.stream()
                .map((el -> el.getText().trim()))
                .collect(Collectors.toList());
    }
}