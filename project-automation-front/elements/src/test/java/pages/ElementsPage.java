package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ElementsPage extends BasePage {

    private By webTables = By.xpath("//span[text()='Web Tables']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void acessarWebTables() {

        removerAds();
        esperar(500);

        WebElement menu = esperarClicar(webTables);
        scrollTo(menu);
        jsClick(menu);
    }
}
