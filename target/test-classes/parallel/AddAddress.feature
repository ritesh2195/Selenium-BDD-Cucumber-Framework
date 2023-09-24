Feature: Add and update address in amazon account

  @address
  Scenario: Add new address in amazon account
    Given user logged in amazon account
    And user navigate to your address page
    When user clicks on add address
    And user enters following details
      | Field | Value |
      | Country/Region  | India |
      | Full Name | John Doe |
      | Mobile Number    | 1234567890 |
      | Pin Code | 411067 |
      | Flat, House no., Building, Company, Apartment| Apt 4B |
      | Area, Street, Sector, Village | Hinjawadi Phase 1  |
      | Town/City | Pune  |
      | State  | MAHARASHTRA  |
    And user clicks on add address button
    Then user should see confirmation message
    And address should be added in your address section
