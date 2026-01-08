package steps;

import api.AccountUser;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.UUID;

public class CreateUserCaseNegativeSteps {

    AccountUser account = new AccountUser();

    String username = "Beatriz";
    String password = "SenhaForte@123";

    Response userResponse;

    @Given("que eu tenha um usuario ja criado")
    public void usuarioJaCriado() {
        username = "user_" + UUID.randomUUID();
        password = "SenhaForte@123";

        Response response = account.createUser(username, password);
        Assert.assertEquals(201, response.statusCode());
    }

    @When("eu tento criar o mesmo usuario novamente")
    public void tentarCriarUsuarioDuplicado() {
        Response response = account.createUser(username, password);
        userResponse = response;
    }

    @Then("a API deve retornar que o usuario ja existe")
    public void validarErroUsuarioDuplicado() {
        Assert.assertEquals(406, userResponse.statusCode());
        Assert.assertTrue(userResponse.asString().contains("User exists!"));
    }
}