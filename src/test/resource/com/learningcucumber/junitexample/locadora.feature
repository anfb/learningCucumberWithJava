#Author: adriely.nara@gmail.com

@tag
Feature: Rent movies
	Like a user
  I want to register movies rentals 
  To control prices and delivery dates.

  @tag1
  Scenario: Sucessful movie rent
    Given existem 2 filmes em estoque
    And o preco do aluguel for 3 reais
    When quando o filme for alugado
    Then o preco do aluguel sera 3 reais
    And a data de entrega sera no dia seguinte
    And o estoque do filme sera 1 unidade
