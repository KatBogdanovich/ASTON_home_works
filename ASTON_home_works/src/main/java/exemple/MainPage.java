package exemple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open() {
        driver.get("https://www.mts.by");
        driver.manage().window().maximize();
        WebElement cancelCookieButton = driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel')]"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cancelCookieButton));
            cancelCookieButton.click();
        } catch (Exception e) {
        }
    }

    public String getPaymentModuleTitle() {
        WebElement paymentHeader = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        paymentHeader.click();
        return paymentHeader.getText();
    }

    public String getLogoUrl(String logoName) {
        return driver.findElement(By.xpath("//img[@alt='" + logoName + "']")).getDomAttribute("src");
    }

    public void clickPaymentDetailsLink() {
        driver.findElement((By.xpath("//a[contains(@href,'help/poryadok')]"))).click();
    }

    public void typePhoneNumber(String phoneNumber) {
        driver.findElement(By.id("connection-phone")).sendKeys(phoneNumber);
    }

    public void typeSum(String sum) {
        driver.findElement(By.id("connection-sum")).sendKeys(sum);
    }

    public void typeEmail(String email) {
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }

    public void clickContinuePaymentButton() {
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
    }

    public String getPhoneNumberPlaceholder() {
        return getElementPlaceholder(By.id("connection-phone"));
    }

    public String getSubscriberNumberPlaceholder() {
        return getElementPlaceholder(By.id("internet-phone"));
    }

    public String getAccountNumberPlaceholder() {
        return getElementPlaceholder(By.id("score-instalment"));
    }

    public String getDebtNumberPlaceholder() {
        return getElementPlaceholder(By.id("score-arrears"));
    }

    public String getSumPlaceholder() {
        return getElementPlaceholder(By.id("arrears-sum"));
    }

    public String getEmailPlaceholder() {
        return getElementPlaceholder(By.id("arrears-email"));
    }

    public void selectPaymentType(String paymentType) {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//*[@class='select__list']//p[text()='" + paymentType + "']")).click();
    }

    private String getElementPlaceholder(By by) {
        return driver.findElement(by).getDomAttribute("placeholder");
    }

    public void fillAndConfirmPaymentByPhone(String phone, String sum, String email) {
        typePhoneNumber(phone);
        typeSum(sum);
        typeEmail(email);
        clickContinuePaymentButton();
    }
}
