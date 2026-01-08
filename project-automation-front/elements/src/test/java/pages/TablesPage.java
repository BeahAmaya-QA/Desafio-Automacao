package pages;

import org.openqa.selenium.*;
import pages.BasePage;

public class TablesPage extends BasePage {

    private By addButton = By.id("addNewRecordButton");
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By userEmailInput = By.id("userEmail");
    private By ageInput = By.id("age");
    private By salaryInput = By.id("salary");
    private By departmentInput = By.id("department");
    private By submitButton = By.id("submit");

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public void clicarAdicionar() {
        removerAds();

        WebElement botaoAdd = driver.findElement(addButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll até o botão usando WebElement
        js.executeScript("arguments[0].scrollIntoView(true);", botaoAdd);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {}

        try {
            botaoAdd.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", botaoAdd);
        }
    }

    public void preencherFormulario(String nome, String sobrenome, String idade, String depto, String salario, String email) {
        removerAds();
        driver.findElement(firstNameInput).sendKeys(nome);
        driver.findElement(lastNameInput).sendKeys(sobrenome);
        driver.findElement(ageInput).sendKeys(idade);
        driver.findElement(salaryInput).sendKeys(salario);
        driver.findElement(departmentInput).sendKeys(depto);
        driver.findElement(userEmailInput).sendKeys(email);
        driver.findElement(submitButton).click();
    }

    public void editarPrimeiroRegistro(String novoSalario) {
        removerAds();
        driver.findElement(By.cssSelector("#edit-record-1")).click();
        driver.findElement(salaryInput).clear();
        driver.findElement(salaryInput).sendKeys(novoSalario);
        driver.findElement(submitButton).click();
    }

    public void deletaroRegistro(String nome) {
        removerAds();
        String xpathLinha = "//div[@role='rowgroup']//div[@class='rt-td' and text()='" + nome + "']/parent::div";

        WebElement linha = driver.findElement(By.xpath(xpathLinha));
        WebElement botaoDelete = linha.findElement(By.cssSelector("span[title='Delete']"));
        botaoDelete.click();
    }
}
