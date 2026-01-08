package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class HomePage extends BasePage {

    private By elementsCard = By.xpath("//h5[text()='Elements']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clicarElements() {
        removerAds();

        WebElement card = esperarClicar(elementsCard);
        scrollTo(card);
        jsClick(card);
    }
}
