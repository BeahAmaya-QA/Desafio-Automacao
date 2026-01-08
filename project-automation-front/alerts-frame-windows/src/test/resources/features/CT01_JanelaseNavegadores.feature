Feature: Browser Windows DemoQA

  Scenario: Abrir nova janela
    Given que estou na pagina inicial do DemoQA
    When acesso o menu Alerts, Frame & Windows
    And acesso o submenu Browser Windows
    And clico no botao New Window
    Then uma nova janela deve ser aberta e exibir a mensagem "This is a sample page"
    And fecho a nova janela
