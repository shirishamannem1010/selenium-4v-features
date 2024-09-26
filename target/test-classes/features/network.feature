Feature: Network Monitoring using Chrome DevTools

  Scenario: Capture network requests
    Given I launch the browser
    When I enable network monitoring
    Then I should capture the network requests
