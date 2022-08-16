#Author: Thilini

Feature: User Departments

  Scenario: Verify Printing Duplicate Users in All Departments
    Given User access the Cloudwise page
    And User clicks "Netherland" as the language
    When User goes to "Dit is Cloudwise" menu
    And User selects "Alle Cloudwisers" sub-menu
    Then Print all duplicate users exist in all departments 