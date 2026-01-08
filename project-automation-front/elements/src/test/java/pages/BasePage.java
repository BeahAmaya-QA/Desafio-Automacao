package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Remover ads do DemoQA
    public void removerAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "document.querySelectorAll('iframe, #adplus-anchor, .advertisement').forEach(e => e.remove());"
            );
        } catch (Exception e) {
            System.out.println("Não foi possível remover anúncios.");
        }
    }

    // Scroll para o elemento
    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Clique via JS (quando o Selenium não consegue clicar)
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Esperar o elemento ficar clicável
    public WebElement esperarClicar(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Esperar elemento aparecer
    public WebElement esperarPresenca(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Sleep simples
    public void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {}
    }
}
