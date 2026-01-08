package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By formsCard = By.xpath("//div[@class='card-body'][.//h5[text()='Forms']]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarForms() {
        WebElement formsCard = driver.findElement(By.xpath("//div[@class='card-body'][.//h5[text()='Forms']]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsCard);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", formsCard);
    }
}