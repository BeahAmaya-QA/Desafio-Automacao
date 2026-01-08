package steps;

import api.AccountUser;
import api.BookApi;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.UUID;

public class BookUserSteps {

    AccountUser account = new AccountUser();
    BookApi booksApi = new BookApi();

    String username = "Beatriz";
    String password = "SenhaForte@123";
    String userId;
    String token;
    String[] chosen = new String[2];

    Response booksResponse;

    //colocar cenario negativo de tentar o usuario 2x

    @Given("que eu crio um novo usuario")
    public void criarUsuario() {
        username = "user_" + UUID.randomUUID();
        Response response = account.createUser(username, password);

        Assert.assertEquals(201, response.statusCode());
        userId = response.jsonPath().getString("userID");
    }

    @When("eu gero um token de acesso")
    public void gerarToken() {
        Response response = account.generateToken(username, password);
        token = response.jsonPath().getString("token");

        Assert.assertNotNull(token);
    }

    @When("verifico se o usuario está autorizado")
    public void autorizado() {
        Response response = account.checkAuthorized(username, password);

        Assert.assertEquals("true", response.asString());
    }

    @When("listo todos os livros disponiveis")
    public void listarLivros() {
        booksResponse = booksApi.listBooks();

        Assert.assertEquals(200, booksResponse.statusCode());
    }

    @When("alugo dois livros")
    public void alugar() {
        booksResponse = booksApi.listBooks();

        chosen[0] = booksResponse.jsonPath().getString("books[2].isbn");
        chosen[1] = booksResponse.jsonPath().getString("books[5].isbn");

        Response response = booksApi.rentBooks(userId, token, chosen);
        Assert.assertEquals(201, response.statusCode());
    }

    @Then("o usuario deve conter os livros alugados")
    public void validar() {
        Response response = account.getUser(userId, token);

        Assert.assertEquals(chosen[0], response.jsonPath().getString("books[0].isbn"));
        Assert.assertEquals(chosen[1], response.jsonPath().getString("books[1].isbn"));
        Assert.assertNotNull(response.jsonPath().getString("books"));
    }
}