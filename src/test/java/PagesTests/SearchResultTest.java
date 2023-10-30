package PagesTests;

import MainData.PageUtils;
import Model.DataForTest;
import PagesObjects.SubMenuPage;
import PagesObjects.WomenItemsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SearchResultTest extends PagesTests.BaseTest {

    private SubMenuPage subMenuPage;
    private WomenItemsPage womenItemsPage;

    @BeforeEach
    public void setUpTest() {
        driver = new FirefoxDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        subMenuPage = new SubMenuPage(driver);
        womenItemsPage = new WomenItemsPage(driver);

    }

    @Test
    @Order(1)
    public void searchObjectTest() {
        subMenuPage.inputTextInSearchObject(DataForTest.SEARCH_WOMEN_ITEMS);
        subMenuPage.clickSearchObjectLink();

        List<String> productsNameWomen = womenItemsPage.getProductsNameWomen();
        assertThat(productsNameWomen).contains(DataForTest.SEARCH_WOMEN_ITEMS);

        List<Integer> productsPriceWomen = womenItemsPage.getProductsPriceWomen();
        assertThat(productsPriceWomen).contains(27);
    }
}