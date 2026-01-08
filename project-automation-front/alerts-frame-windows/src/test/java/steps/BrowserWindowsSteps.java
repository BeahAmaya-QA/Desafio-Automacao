package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.BrowserWindowsPage;
import support.DriverFactory;
import org.junit.Assert;

public class BrowserWindowsSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage = new HomePage(driver);
    private BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);

    @Given("que estou na pagina inicial do DemoQA")
    public void abrirSite() {
        driver.get("https://demoqa.com/");
    }

    @When("acesso o menu Alerts, Frame & Windows")
    public void acessoMenuAlertsFrameWindows() throws InterruptedException {
        homePage.clicarAlertsFrameWindows();
        Thread.sleep(500);
    }

    @When("acesso o submenu Browser Windows")
    public void acessoSubmenuBrowserWindows() throws InterruptedException {
        homePage.clicarBrowserWindowsSubmenu();
        Thread.sleep(500);
    }

    @When("clico no botao New Window")
    public void clicarNewWindow() {
        browserWindowsPage.clicarNewWindow();
    }

    @Then("uma nova janela deve ser aberta e exibir a mensagem {string}")
    public void validarNovaJanela(String mensagemEsperada) {
        String texto = browserWindowsPage.mensagemNovaJanela();
        Assert.assertEquals(mensagemEsperada, texto);
    }

    @Then("fecho a nova janela")
    public void fecharNovaJanela() {
        browserWindowsPage.fecharNovaJanela();
    }

    @After
    public void fecharBrowser() {
        DriverFactory.closeDriver();
    }
}
