Feature: Ordenação de elementos sortables

  Scenario: Ordenar os elementos na ordem crescente
    Given que estou na página inicial do DemoQA
    When acesso Interactions e clico na opção Sortable
    And ordeno os elementos na ordem crescente
    Then os elementos devem estar corretamente ordenados
