package com.unisuper.test.uitest.angularjs.tasks;

import com.unisuper.test.uitest.angularjs.steps.ToDoMvcSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ToDoMvcTasks
{

    @Steps
    ToDoMvcSteps user;

    @Given("^the user is on the todomvc application home page$")
    public void theUserIsOnTheTodoMvcHomePage()
    {
        user.opensHomePage();
    }

    @And("^the user navigates to AngularJS version of todo web application$")
    public void theUserNavigatesToAngularJSVersionOfToDOWebApplication()
    {
        user.navigateToAngularJsImplementation();
    }

    @And("^the user types a todo item \"([^\"]*)\" in the todo input box$")
    public void theUserTypesATodoItemInTheTodoInputBox(String toDoItem)
    {
        user.typeToDoItemInInputbox(toDoItem);
    }

    @And("^the user adds a todo item \"([^\"]*)\" in the todo list$")
    public void theUserAddsATodoItem(String toDoItem)
    {
        user.addToDoItem(toDoItem);
    }

    @Given("^the user presses enter button$")
    public void theUserPressesEnterButton()
    {
        user.pressEnterInToDoInputbox();
    }

    @Then("^the item \"([^\"]*)\" is displayed to the user in the todo list$")
    public void theItemIsDisplayedToTheUserInTheTodoList(String toDoItem)
    {
        user.validateToDoItemPresent(toDoItem);
    }

    @When("^the user clicks on the displayed todo item \"([^\"]*)\" to edit with new value \"([^\"]*)\"$")
    public void theUserClicksOnTheDisplayedToDoItem(String toDoItemOld, String toDoItemNew)
    {
        user.updateToDoItem(toDoItemOld, toDoItemNew);
    }

    @When("^the user clicks inside the circle to the left of \"([^\"]*)\" item$")
    public void theUserClicksInsideTheCircleToTheLeftOfItem(String toDoItem)
    {
        user.markItemCompleted(toDoItem);
    }

    @Then("^the item \"([^\"]*)\" is marked as completed$")
    public void theItemIsMarkedAsCompleted(String toDoItem)
    {
        user.verifyItemCompleted(toDoItem);
    }

    @Then("^the item \"([^\"]*)\" is marked as active$")
    public void theItemIsMarkedAsActive(String toDoItem)
    {
        user.verifyItemActive(toDoItem);
    }

}
