package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By alertsFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By browserWindowsSubmenu = By.xpath("//span[text()='Browser Windows']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clicarComJS(WebElement elemento) {
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public void clicarAlertsFrameWindows() {
        clicarComJS(driver.findElement(alertsFrameWindowsMenu));
    }

    public void clicarBrowserWindowsSubmenu() {
        clicarComJS(driver.findElement(browserWindowsSubmenu));
    }
}
