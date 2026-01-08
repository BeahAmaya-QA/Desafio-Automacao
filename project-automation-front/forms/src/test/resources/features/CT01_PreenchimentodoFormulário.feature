Feature: Preencher formulário do DemoQA

  Scenario: Submeter o Practice Form com sucesso
    Given que estou na pagina inicial do DemoQA
    When acesso o menu Forms
    And clico em Practice Form
    And preencho todo o formulario com dados validos
    And submeto o formulario
    Then o popup de confirmacao deve ser exibido
    And fecho o popup
