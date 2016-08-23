Feature: Amazon search feature
  As a <role>,
    I want to <goal/desire>,
      so that <benefit>

  @chrome
  Scenario: Amazon.Demo.Search
    Given the following page is displayed "http://amazon.com"
      When "Software Testing" is entered in search bar
        When Search button is pressed
          Then the "1" result title should be "Software Testing (2nd Edition)"
          Then the "5" result title should be "Software Testing: An ISTQB-BCS Certified Tester Foundation Guide 3rd ed"





