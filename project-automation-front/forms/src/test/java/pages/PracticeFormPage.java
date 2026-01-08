package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PracticeFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By mobile = By.id("userNumber");
    private By dateBirthInput = By.id("dateOfBirthInput");
    private By selectMes = By.className("react-datepicker__month-select");
    private By selectAno = By.className("react-datepicker__year-select");
    private By subject = By.id("subjectsInput");
    private By genderFemale = By.xpath("//label[text()='Female']");
    private By hobbySports = By.xpath("//label[text()='Sports']");
    private By upload = By.id("uploadPicture");
    private By address = By.id("currentAddress");
    private By submit = By.id("submit");
    private By popup = By.id("example-modal-sizes-title-lg");
    private By closePopup = By.id("closeLargeModal");

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Metodo lida com anuncios que sobrepõem o formulário
    private void clicarComJS(WebElement elemento) {
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    private void escreverDevagar(WebElement elemento, String texto) {
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.clear();
        for (char c : texto.toCharArray()) {
            elemento.sendKeys(String.valueOf(c));
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }
    }

    //Metodo React Selct
    private void selecionarReactSelect(By container, String valor) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(container)));
        element.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'css-26l3qy-menu')]//div[text()='" + valor + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }

    //Formulário
    public void preencherFormulario() {
        escreverDevagar(driver.findElement(firstName), "Beatriz");
        escreverDevagar(driver.findElement(lastName), "Amaya");
        escreverDevagar(driver.findElement(email), "beatriz.lima@test.com");

        clicarComJS(driver.findElement(genderFemale));
        escreverDevagar(driver.findElement(mobile), "11954874587");

        // Data de nascimento
        driver.findElement(dateBirthInput).click();
        new Select(driver.findElement(selectMes)).selectByValue("11"); // Dezembro
        new Select(driver.findElement(selectAno)).selectByValue("1999");
        WebElement dia6 = driver.findElement(By.xpath("//div[@aria-label='Choose Monday, December 6th, 1999']"));
        clicarComJS(dia6);

        // Subjects
        escreverDevagar(driver.findElement(subject), "Maths");

        // Hobbies
        clicarComJS(driver.findElement(hobbySports));

        // Upload de arquivo
        String filePath = "src/test/resources/files/arquivoTeste.txt";
        File file = new File(filePath);
        if (!file.exists()) throw new RuntimeException("Arquivo não encontrado: " + filePath);
        driver.findElement(upload).sendKeys(file.getAbsolutePath());

        // Endereço
        escreverDevagar(driver.findElement(address), "Avenida Sapopemba, 14100 - SP");

        // State e City
        selecionarReactSelect(By.id("state"), "Haryana");
        selecionarReactSelect(By.id("city"), "Panipat");
    }

    public void submeter() {
        clicarComJS(driver.findElement(submit));
    }

    public boolean popupAberto() {
        return driver.findElement(popup).isDisplayed();
    }

    public void fecharPopup() {
        clicarComJS(driver.findElement(closePopup));
    }
}
