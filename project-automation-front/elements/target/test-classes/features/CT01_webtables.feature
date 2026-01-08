Feature: Gerenciamento de registros na WebTables

  Scenario: Criar, editar e deletar um registro
    Given que estou no site DemoQA
    And acesso o menu Elements
    And acesso o submenu Web Tables
    When crio um novo registro com os dados "Beatriz" "Lima" "25" "QA" "5000" "beatriz@email.com"
    Then edito o registro criado alterando o salário para "7000"
    And deleto o registro criado