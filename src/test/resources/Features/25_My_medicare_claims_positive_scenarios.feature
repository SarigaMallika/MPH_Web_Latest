Feature: Validation on My medicare claims

  #Click on the claims under My Medicare page and navigated to the claims details page
  Scenario: Validate navigation to claims page
    Given Launch the URL and click on Login button
    When Clicks on the Circles from home dashboard
    Then Select My Medicare
    And Click on Claims from the My Medicare dashbord

  Scenario: Verify the scenario when Claims title and back arrow visible on the page
    When Claims title and back arrow displayed
    Then Claims title and back arrow displayed on the page

  Scenario: Verify the scenario when select "Claim type" from the dropdown field
    When Select Claim type from the dropdown field
    Then Filtered Claims summary and Claims are displayed

  Scenario: Verify the scenario when select "Time period" from the dropdown field
    When Select Time period from the dropdown field
    Then Filtered Claims summary and Claims page are displayed

  Scenario: Verify the scenario  to view 'Patient portion and Insurer portion' under claims summary
    Given Patient portion and Insurer portion displayed on the page

  Scenario: Verify the scenario  to view 'Here is the helpful breakdown' text under Claims summary
    Given 'Here is the helpful breakdown'  text is displayed on the page

  Scenario: Verify the scenario claims breakdown is visible
    Given All the breakdown and total amount are displayed

  Scenario: Verify the scenario to sort claims under 'Claims' tab
    When Click on funnel icon then select Date created and Date created
    Then Oldest and Newest claims claims are diplayed

  Scenario: Verify the scenario to view total number of claims
    Then Total number records found text displayed.Also, user should able to see the list of records with Date

  Scenario: Verify the scenario to select one claim under the list of claims
    When Select one claim under list of claims
    Then Selected claim details displayed

  Scenario: Verify the scenario when selected claim service details can be visible
    When Expand and view Services of selected claim
    Then Services details should be displayed

  Scenario: Verify the scenario when clicking on related records
    Given Click on all the icons under related records

  Scenario: Verify the sceario when clicking on More icon
    Given Click on 'More' icon and select each icon under 'More' popup
