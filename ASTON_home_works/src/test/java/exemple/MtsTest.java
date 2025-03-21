package exemple;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void testSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.mts.by");
        driver.manage().window().maximize();
        WebElement cancelCookieButton = driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel')]"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cancelCookieButton));
            cancelCookieButton.click();
        } catch (Exception e) {
        }

    }

    @Test
    public void checkTitle() {
        WebElement paymentHeader = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        paymentHeader.click();
        assertEquals("Онлайн пополнение\nбез комиссии", paymentHeader.getText(),
                "Заголовок блока пополнения не соответствует");
    }

    @Test
    public void checkLogos() {
        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        WebElement visaVerifiedLogo = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        WebElement masterCardLogo = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        WebElement masterCardSecureCodeLogo = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
        WebElement belkartLogo = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        assertAll(
                () -> assertTrue(visaLogo.getDomAttribute("src").contains("visa.svg"),
                        "Некорректная ссылка на логотип Visa."),
                () -> assertTrue(visaVerifiedLogo.getDomAttribute("src").contains("visa-verified.svg"),
                        "Некорректная ссылка на логотип Visa Verified."),
                () -> assertTrue(masterCardLogo.getDomAttribute("src").contains("mastercard.svg"),
                        "Некорректная ссылка на логотип MasterCard."),
                () -> assertTrue(masterCardSecureCodeLogo.getDomAttribute("src").contains("mastercard-secure.svg"),
                        "Некорректная ссылка на логотип MasterCard Secure Code."),
                () -> assertTrue(belkartLogo.getDomAttribute("src").contains("belkart.svg"),
                        "Некорректная ссылка на логотип Белкарт.")
        );
    }

    @Test
    public void checkLinkWorks() {
        driver.findElement((By.xpath("//a[contains(@href,'help/poryadok')]"))).click();
        assertEquals("Порядок оплаты и безопасность интернет платежей", driver.getTitle(),
                "Ссылка открывает некорректную страницу.");
    }

    @Test
    public void checkPaymentInput() throws InterruptedException {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("12");
        driver.findElement(By.id("connection-email")).sendKeys("k82b@mail.ru");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        String frameLocator = "//*[@class='bepaid-iframe']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(frameLocator)));
        driver.switchTo().frame(driver.findElement(By.xpath(frameLocator)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-input//app-input")));

        assertTrue(driver.findElement(By.className("pay-description__text")).getText().contains("297777777"),
                "Неверный номер телефона");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
