package PagesTests;

import MainData.PageUtils;
import PagesObjects.BestSellersItemsPage;
import PagesObjects.PopularItemsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class HomePageTest extends PagesTests.BaseTest {

    private PopularItemsPage popularItemsPage;
    private BestSellersItemsPage bestSellersItemsPage;

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
        bestSellersItemsPage = new BestSellersItemsPage(driver);
    }

    @Test
    @Order(1)
    public void shouldSeePopularItemsOnHomePage() {
        List<String> productsNames = popularItemsPage.getProductsNames();
        List<String> productsPopularNamesEmptyList = productsNames.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());

        assertThat(productsPopularNamesEmptyList.isEmpty()).isTrue();
    }

    @Test
    @Order(2)
    public void shouldSeeBestSellersItemsOnHomePage() {
        bestSellersItemsPage.clickButtonBestSellers();
        List<String> productsNamesBestSellers = bestSellersItemsPage.getProductsNamesBestSellers();
        List<String> productsBestSellersNamesEmptyList = productsNamesBestSellers.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());

        assertThat(productsBestSellersNamesEmptyList.isEmpty()).isTrue();
    }
}