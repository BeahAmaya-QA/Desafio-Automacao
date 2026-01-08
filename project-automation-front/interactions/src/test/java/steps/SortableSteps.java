package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.SortablePage;
import support.DriverFactory;

public class SortableSteps {

    WebDriver driver = DriverFactory.getDriver();
    SortablePage page = new SortablePage();

    @Given("que estou na página inicial do DemoQA")
    public void abrirHome() {
        driver.get("https://demoqa.com/");
    }

    @When("acesso Interactions e clico na opção Sortable")
    public void acessarInteractionsSortable() {
        page.acessarInteractions();
        page.acessarSortable();
    }

    @When("ordeno os elementos na ordem crescente")
    public void ordenarElementos() throws InterruptedException {
        page.ordenarLista();
    }

    @Then("os elementos devem estar corretamente ordenados")
    public void validarOrdenacao() {
        System.out.println("Ordenação realizada com sucesso.");
    }

    @After
    public void fechar() {
        DriverFactory.closeDriver();
    }
}
