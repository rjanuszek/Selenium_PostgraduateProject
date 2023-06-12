package PagesTests;

import MainData.PageUtils;
import Model.DataForContactUsForm;
import PagesObjects.ContactUsFormPage;
import PagesObjects.TopMenuPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ContactUsTest extends PagesTests.BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    @Order(1)
    public void shouldNotAllowToSendEmptyContactUsForm() {
        topMenuPage.clinkOnContactUsLink();
        contactUsFormPage.clickOnSendButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
        assertThat(contactUsFormPage.redBoxText()).contains(PageUtils.ERROR_TEXT_FOR_EMPTY_CONTACT_US_FORM);
    }

    @Test
    @Order(2)
    public void shouldSendContactUsFormWithValidData() throws FileNotFoundException {
        topMenuPage.clinkOnContactUsLink();

        contactUsFormPage.sendContactUsForm(DataForContactUsForm.getDefaultMessage());
        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}