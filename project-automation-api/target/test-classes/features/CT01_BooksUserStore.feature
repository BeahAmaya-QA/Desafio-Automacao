Feature: Fluxo completo da API DemoQA Bookstore

  Scenario: Executar fluxo completo de criacao de usuario, token, autorizacao e aluguel de livros
    Given que eu crio um novo usuario
    When eu gero um token de acesso
    And verifico se o usuario está autorizado
    And listo todos os livros disponiveis
    And alugo dois livros
    Then o usuario deve conter os livros alugados
