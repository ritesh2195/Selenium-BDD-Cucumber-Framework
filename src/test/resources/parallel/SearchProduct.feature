Feature: Search product feature


  Scenario: Auto populated list in search text box

    When user enters "badminton" in search text box
    Then verify auto populated list contains "badminton"

  @search
  Scenario: Search product anc check auto populated list
    When user enters "badminton" in search text box
    And user selects "badminton rackets" from auto populated list
    And user clicks on first product in search result page
    And user adds product in the cart
    Then user should see the product in my cart
    And verify cart total price