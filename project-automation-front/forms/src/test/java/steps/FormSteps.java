package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.FormPage;
import pages.PracticeFormPage;
import support.DriverFactory;
import org.junit.Assert;

public class FormSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private FormPage formsPage = new FormPage(driver);
    private PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

    @Given("que estou na pagina inicial do DemoQA")
    public void abrirSite() {
        driver.get("https://demoqa.com/");
    }

    @When("acesso o menu Forms")
    public void acessoForms() throws InterruptedException {
        homePage.clicarForms();
        Thread.sleep(800);
    }

    @When("clico em Practice Form")
    public void clicoPracticeForm() throws InterruptedException {
        formsPage.clicarPracticeForm();
        Thread.sleep(800);
    }

    @When("preencho todo o formulario com dados validos")
    public void preencherFormulario() throws InterruptedException {
        practiceFormPage.preencherFormulario();
    }

    @When("submeto o formulario")
    public void submetoFormulario() throws InterruptedException {
        practiceFormPage.submeter();
    }

    @Then("o popup de confirmacao deve ser exibido")
    public void validarPopup() {
        Assert.assertTrue(practiceFormPage.popupAberto());
    }

    @Then("fecho o popup")
    public void fecharPopup() throws InterruptedException {
        practiceFormPage.fecharPopup();
    }

    @After
    public void fecharBrowser() {
        DriverFactory.closeDriver();
    }
}
