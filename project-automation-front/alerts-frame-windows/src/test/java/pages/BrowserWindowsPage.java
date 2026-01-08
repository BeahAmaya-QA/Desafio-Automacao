package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class BrowserWindowsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By newWindowButton = By.id("windowButton");
    private By mensagem = By.id("sampleHeading");

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clicarComJS(WebElement elemento) {
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public void clicarNewWindow() {
        clicarComJS(driver.findElement(newWindowButton));
    }

    public String mensagemNovaJanela() {
        String principal = driver.getWindowHandle();
        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(principal)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        return driver.findElement(mensagem).getText();
    }
    public void fecharNovaJanela() {
        String principal = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(principal)) {
                driver.switchTo().window(handle);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(principal);
    }
}
