package PagesTests;

import MainData.PageUtils;
import PagesObjects.CategoriesPage;
import PagesObjects.WomenItemsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class WomenItemsTest extends PagesTests.BaseTest {

    private CategoriesPage categoriesPage;
    private WomenItemsPage womenItemsPage;


    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        categoriesPage = new CategoriesPage(driver);
        womenItemsPage = new WomenItemsPage(driver);
    }

    @Test
    @Order(1)
    public void shouldSeeWomenItemsOnPageByPrice() {
        categoriesPage.clinkOnWomenLink();
        setTimeouts();
        List<Double> productsPriceWomen = womenItemsPage.getProductsPriceWomen();
        List<Double> listOfPriceZero = productsPriceWomen.stream()
                .filter(el -> el <= 0)
                .collect(Collectors.toList());

        assertThat(listOfPriceZero.isEmpty()).isTrue();
    }
}