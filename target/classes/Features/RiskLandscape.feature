Feature: User navigate to Risk landscape from Dashboard

#  Scenario: Verify user navigate to Geography risk landscape screen from Dashboard
#    Given Login to EiQ application with valid username
#    When user is on dashboard screen
#    When user select country "1" View scorecard from the countries list of New Supply chain risk trends section
#    Then verify user navigate to Geography risk landscape screen

  Scenario: Verify user navigate to Geography risk landscape screen from Dashboard
    Given Login to EiQ application with valid username
    When user is on dashboard screen
    When user click on View All Trends button
    Then verify user navigate to Global risk landscape screen