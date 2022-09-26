@api_trello
Feature: Trello Rest API Board And Card CRUD Operations

  @wip
  Scenario: Board' And Card' https requests with Post, Put and Delete
    #Before create a new Board, should be created a new organization, because system can not assign organization id automatically without organization
    When User send a POST request with "organizations" endpoint for create a new Organization which name is "TrelloOrganization"
    Then Verify that status code 200 and content type "application/json"
    When User send a POST request with "boards/" endpoint for create a new Board and board name should be "TrelloBoard"
    And Verify that status code 200 and content type "application/json"
    Then User send a POST request with "lists/" endpoint for create a new List which name is "TrelloList1", before create a Cards
    And Verify that status code 200 and List name equals "TrelloList1"
    Then User send a POST request with "cards/" endpoint for create two new Cards and cards name should be "TrelloCard1" and "TrelloCard2"
    And Verify that status code 200 and card' names equal "TrelloCard1" and "TrelloCard2"
    Then User send a PUT request with "cards/{id}" endpoint for update one random card and updated card' name should be "TrelloCardUpdate1"
    And Verify that status code 200 and updated card' names equal "TrelloCardUpdate1"
    Then User send a DELETE request with "cards/{id}" endpoint for delete a Cards
    And Verify that status code 200 and content type "application/json"
    Then User send a DELETE request with "boards/{id}" endpoint for delete a Board
    And Verify that status code 200 and content type "application/json"







