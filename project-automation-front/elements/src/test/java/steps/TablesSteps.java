package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ElementsPage;
import pages.TablesPage;
import support.DriverFactory;

public class TablesSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private TablesPage tablesPage = new TablesPage(driver);

    @Given("que estou no site DemoQA")
    public void acessarSite() {
        driver.get("https://demoqa.com");
    }

    @And("acesso o menu Elements")
    public void acessarElements() {
        homePage.clicarElements();
    }

    @And("acesso o submenu Web Tables")
    public void acessarWebTables() {
        elementsPage.acessarWebTables();
    }

    @And("crio um novo registro com os dados {string} {string} {string} {string} {string} {string}")
    public void criarRegistro(String nome, String sobrenome, String idade, String cargo, String salario, String email) {
        tablesPage.clicarAdicionar();
        tablesPage.preencherFormulario(nome, sobrenome, idade, cargo, salario, email);
    }

    @Then("edito o registro criado alterando o salário para {string}")
    public void editarRegistro(String novoSalario) {
        tablesPage.editarPrimeiroRegistro(novoSalario);
    }

    @And("deleto o registro criado")
    public void deletarRegistro() {
        tablesPage.deletaroRegistro("Beatriz");
    }
}
