Feature: Fluxo Negativo de Cricao de usuario

    Scenario: Tentativa de criar um usuario ja existente
        Given que eu tenha um usuario ja criado
        When eu tento criar o mesmo usuario novamente
        Then a API deve retornar que o usuario ja existe
