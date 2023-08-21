Feature: Customer

  Scenario Outline: Common steps for customer
    Given User launch a chrome browser
    When Enters a url as "https://admin-demo.nopcommerce.com/login"
    And User enter email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then User can view a Dashboard
    When User click on Customer menu
    And click on Customer menu item
    Then User can view a Customer Dashboard page
    Examples:
      | email |password
      | admin@yourstore.com |admin
      |admin@yourstore.com  |admin123



  Scenario: Add a new Customer
    When click on Add customer button
    Then Add a new customer page displays
    When User add customer info
    And click on save button
    Then User get a confirmation "The new customer has been added successfully."
    And browser closed


  Scenario: Search Existing customer by EmailId
    When User enter emailId
    And click on search button
    Then User should be able to find Emailid in table
    And browser closed



