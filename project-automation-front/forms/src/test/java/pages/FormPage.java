package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private WebDriver driver;
    private By practiceFormBtn = By.xpath("//span[text()='Practice Form']");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarPracticeForm() {
        driver.findElement(practiceFormBtn).click();
    }
}
