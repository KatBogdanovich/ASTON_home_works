package exemple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitToLoad() {
        String frameLocator = "//*[@class='bepaid-iframe']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(frameLocator)));
        driver.switchTo().frame(driver.findElement(By.xpath(frameLocator)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-input//app-input")));
    }

    public String getPaymentFrameDescription() {
        return driver.findElement(By.className("pay-description__text")).getText();
    }

    public String getPaymentSum() {
        return driver.findElement(By.xpath("//*[@class='pay-description__cost']//span")).getText();
    }

    public String getConfirmButtonText() {
        return driver.findElement(By.xpath("//*[@class='card-page__card']//button")).getText();
    }

    public String getCardNumberInputText() {
        return driver.findElement(By.xpath("//*[@id='cc-number']/following-sibling::label")).getText();
    }

    public String getValidityPeriodInputText() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-exp']/following-sibling::label")).getText();
    }

    public String getHolderNameInputText() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-name']/following-sibling::label")).getText();
    }

    public String getCvcCodeInputText() {
        return driver.findElement(By.xpath("//*[@autocomplete='cc-csc']/following-sibling::label")).getText();
    }

    public boolean isLogoPresent(String logoName) {
        List<WebElement> logoImages = driver.findElements(By.xpath("//*[contains(@class, 'cards-brands__container')]//img"));
        for (WebElement element : logoImages) {
            if (element.getDomAttribute("src").contains(logoName))
                return true;
        }
        return false;
    }
}
