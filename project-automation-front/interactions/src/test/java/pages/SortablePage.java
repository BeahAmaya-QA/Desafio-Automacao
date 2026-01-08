package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverFactory;

import java.time.Duration;
import java.util.List;

public class SortablePage {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    private By interactionsMenu = By.xpath("//h5[text()='Interactions']");
    private By sortableMenu = By.xpath("//span[text()='Sortable']");
    private By listItems = By.cssSelector("div.vertical-list-container div.list-group-item");

    public void removerBloqueios() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "let ids=['fixedban','adplus-anchor'];" +
                        "ids.forEach(id => { var el = document.getElementById(id); if(el) el.remove(); });" +
                        "let classes=['fc-consent-root','fc-banner','footer','adsbygoogle'];" +
                        "classes.forEach(c => { var el = document.querySelector('.'+c); if(el) el.remove(); });";
        js.executeScript(script);
    }

    public void clickJs(By locator) {
        removerBloqueios();
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void acessarInteractions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(interactionsMenu));
        clickJs(interactionsMenu);
    }

    public void acessarSortable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortableMenu));
        clickJs(sortableMenu);
    }

    public List<WebElement> getElements() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listItems));
    }

    public void ordenarLista() throws InterruptedException {
        List<WebElement> itens = getElements();
        String[] ordemEsperada = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        boolean jaOrdenada = true;
        for (int i = 0; i < ordemEsperada.length && i < itens.size(); i++) {
            String texto = itens.get(i).getText().trim();
            if (!texto.equalsIgnoreCase(ordemEsperada[i])) {
                jaOrdenada = false;
                break;
            }
        }
        if (jaOrdenada) {
            System.out.println("A lista já está na ordem esperada.");
            return;
        }
        // Se não estiver ordenada, ordena
        for (int i = 0; i < ordemEsperada.length && i < itens.size(); i++) {
            for (int j = i; j < itens.size(); j++) {
                if (itens.get(j).getText().trim().equalsIgnoreCase(ordemEsperada[i])) {
                    if (j != i) {
                        WebElement origem = itens.get(j);
                        WebElement destino = itens.get(i);
                        ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].scrollIntoView({block:'center'});", destino);
                        new org.openqa.selenium.interactions.Actions(driver)
                            .dragAndDrop(origem, destino)
                            .perform();
                        Thread.sleep(500);
                        itens = getElements();
                    }
                    break;
                }
            }
        }
    }
}
