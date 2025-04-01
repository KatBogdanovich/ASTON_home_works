package exemple;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;
    private static WebDriverWait wait;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void testSetUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        paymentPage = new PaymentPage(driver);
    }

    @Test
    @DisplayName("Проверка названия : Онлайн пополнение без комиссии.")
    @Description("Найти и сверить название блока на странице.")
    public void checkTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getPaymentModuleTitle(),
                "Заголовок блока пополнения не соответствует");
    }

    @Test
    @DisplayName("Проверка наличия на странице всех логотипов платежных систем.")
    @Description("Найти в блоке пополнение без комиссии логотипы платежных систем, принимаемых к оплате.")
    public void checkLogos() {
        assertAll(
                () -> assertTrue(mainPage.getLogoUrl("Visa").contains("visa.svg"),
                        "Некорректная ссылка на логотип Visa."),
                () -> assertTrue(mainPage.getLogoUrl("Verified By Visa").contains("visa-verified.svg"),
                        "Некорректная ссылка на логотип Visa Verified."),
                () -> assertTrue(mainPage.getLogoUrl("MasterCard").contains("mastercard.svg"),
                        "Некорректная ссылка на логотип MasterCard."),
                () -> assertTrue(mainPage.getLogoUrl("MasterCard Secure Code").contains("mastercard-secure.svg"),
                        "Некорректная ссылка на логотип MasterCard Secure Code."),
                () -> assertTrue(mainPage.getLogoUrl("Белкарт").contains("belkart.svg"),
                        "Некорректная ссылка на логотип Белкарт.")
        );
    }

    @Test
    @DisplayName("Проверка работы ссылки : Подробнее о сервисе.")
    @Description("Проверить осуществляется переход на страницу (Порядок оплаты и безопасность интернет платежей)")
    public void checkLinkWorks() {
        mainPage.clickPaymentDetailsLink();
        assertEquals("Порядок оплаты и безопасность интернет платежей", driver.getTitle(),
                "Ссылка открывает некорректную страницу.");
    }

    @Test
    @DisplayName("Проверка заполнения полей в форме Оплаты и работы кнопки Продолжить")
    @Description("Проверить корректность заполнения полей, только для Услуги связи и переход на страницу Оплаты. Переход подтверждается проверкой номера телефона.")
    public void checkPaymentInput() {
        mainPage.fillAndConfirmPaymentByPhone("297777777", "12", "k82b@mail.ru");
        mainPage.clickContinuePaymentButton();
        paymentPage.waitToLoad();

        assertTrue(paymentPage.getPaymentFrameDescription().contains("297777777"),
                "Неверный номер телефона");
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях для каждого вида услуг.")
    @Description("Проверить для каждой услуги надпись в каждом незаполненном поле.")
    public void checkPlaceholders() {
        String errorMessage = "Некорректный плейсхолдер";

        assertAll(
                () -> assertEquals("Номер телефона", mainPage.getPhoneNumberPlaceholder(), errorMessage),
                () -> assertEquals("Номер абонента", mainPage.getSubscriberNumberPlaceholder(), errorMessage),
                () -> assertEquals("Номер счета на 44", mainPage.getAccountNumberPlaceholder(), errorMessage),
                () -> assertEquals("Номер счета на 2073", mainPage.getDebtNumberPlaceholder(), errorMessage),
                () -> assertEquals("Сумма", mainPage.getSumPlaceholder(), errorMessage),
                () -> assertEquals("E-mail для отправки чека", mainPage.getEmailPlaceholder(), errorMessage)
        );
    }

    @Test
    @DisplayName("Проверка корректности отображения информации.")
    @Description("Проверить корректность отображения номера телефона, суммы платежа, email-адреса, надписей в незаполненных полях для реквизитов карты.")
    public void checkPaymentPage() {
        mainPage.selectPaymentType("Услуги связи");
        mainPage.fillAndConfirmPaymentByPhone("297777777", "12", "k82b@mail.ru");
        mainPage.clickContinuePaymentButton();
        paymentPage.waitToLoad();

        assertAll(
                () -> assertTrue(paymentPage.getPaymentFrameDescription().contains("297777777"),
                        "Неверный номер телефона"),
                () -> assertEquals("12.00 BYN", paymentPage.getPaymentSum(), "Неверная сумма."),
                () -> assertEquals("Оплатить 12.00 BYN", paymentPage.getConfirmButtonText(),
                        "Неверная сумма на кнопке подтверждения оплаты."),
                () -> assertEquals("Номер карты", paymentPage.getCardNumberInputText(),
                        "Неверный текст в поле [Номер карты]."),
                () -> assertEquals("Срок действия", paymentPage.getValidityPeriodInputText(),
                        "Неверный текст в поле [Срок действия]."),
                () -> assertEquals("Имя держателя (как на карте)", paymentPage.getHolderNameInputText(),
                        "Неверный текст в поле [Имя держателя]."),
                () -> assertEquals("CVC", paymentPage.getCvcCodeInputText(), "Неверный текст в поле [CVC].")
        );
    }

    @ParameterizedTest
    @DisplayName("Проверка логотипов платежных систем на странице оплаты.")
    @Description("Проверить наличие иконок платежных систем на странице оплаты")
    @ValueSource(strings = {"visa-system", "mastercard-system", "belkart-system", "maestro-system", "mir-system-ru"})
    public void checkPaymentPageLogos(String logoName) {
        mainPage.selectPaymentType("Услуги связи");
        mainPage.fillAndConfirmPaymentByPhone("297777777", "12", "k82b@mail.ru");
        paymentPage.waitToLoad();

        assertTrue(paymentPage.isLogoPresent(logoName), "Не найден логотип: " + logoName);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
