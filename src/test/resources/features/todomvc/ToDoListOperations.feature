@Regression
Feature: Maintain ToDo List
   In order to remember tasks to be done and completed
   As a user
   I want to be able to create, visualize and maintain a list of TODO items.

  Background: 
  Given the user is on the todomvc application home page 
    And the user navigates to AngularJS version of todo web application
  
  #1. I want to add a To-do item
  @TODO_OPERATIONS_001
  @Smoke
  Scenario: Verify that a todo item can be added to the list
    Given the user types a todo item "TODO1" in the todo input box
     When the user presses enter button
     Then the item "TODO1" is displayed to the user in the todo list
   
  #2. I want to edit the content of an existing To-do item
  @TODO_OPERATIONS_002
  Scenario: Verify that a todo item can be edited in the list
    Given the user adds a todo item "TODO1" in the todo list
      And the item "TODO1" is displayed to the user in the todo list
     When the user clicks on the displayed todo item "TODO1" to edit with new value "TODONew"
     Then the item "TODONew" is displayed to the user in the todo list
     
  #3. I can complete a To-do by clicking inside the circle UI to the left of the To-do
  @TODO_OPERATIONS_003
  Scenario: Verify that a todo item can be marked as completed
    Given the user adds a todo item "TODO1" in the todo list
     When the user clicks inside the circle to the left of "TODO1" item
     Then the item "TODO1" is marked as completed
  
  #4. I can re-activate a completed To-do by clicking inside the circle UI
  @TODO_OPERATIONS_004
  Scenario: Verify that a todo item can be re-activate
    Given the user adds a todo item "TODO1" in the todo list
      And the user clicks inside the circle to the left of "TODO1" item
      And the item "TODO1" is marked as completed
     When the user clicks inside the circle to the left of "TODO1" item
     Then the item "TODO1" is marked as active
     
  #5. I can add a second To-do
  @TODO_OPERATIONS_005
  Scenario: Verify that more than one todo item can be added
    Given the user adds a todo item "TODO1" in the todo list
     Then the item "TODO1" is displayed to the user in the todo list
     When the user adds a todo item "TODO2" in the todo list
     Then the item "TODO1" is displayed to the user in the todo list
      And the item "TODO2" is displayed to the user in the todo list
          