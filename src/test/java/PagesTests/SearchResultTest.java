package PagesTests;

import MainData.PageUtils;
import PagesObjects.SearchResultPage;
import PagesObjects.SubMenuPage;
import PagesObjects.WomenItemsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SearchResultTest extends PagesTests.BaseTest {

    private SubMenuPage subMenuPage;
    private SearchResultPage searchResultPage;
    private WomenItemsPage womenItemsPage;

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        subMenuPage = new SubMenuPage(driver);
        searchResultPage = new SearchResultPage(driver);
        womenItemsPage = new WomenItemsPage(driver);
    }

    @Test
    @Order(1)
    public void searchObjectTest() {
        subMenuPage.inputTextInSearchObject("Blouse");
        subMenuPage.clickSearchObjectLink();

        assertThat(searchResultPage.checkSearchResult("Showing 1 - 1 of 1 item")).isTrue();

        List<String> productsNameWomen = womenItemsPage.getProductsNameWomen();
        assertThat(productsNameWomen).contains("Blouse");

        List<Double> productsPriceWomen = womenItemsPage.getProductsPriceWomen();
        assertThat(productsPriceWomen).contains(27.0);
    }
}