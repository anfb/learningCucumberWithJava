#Author: adriely.nara@gmail.com

@tag
Feature: Learning cucumber

  @tag1
  Scenario: Should increment the counter
    Given That the value is 15
    When I increment 3
    Then the counter value it'll be 18
    