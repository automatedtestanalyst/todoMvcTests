package com.unisuper.test.uitest.angularjs.steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.unisuper.test.uitest.angularjs.pages.ToDoMvcAngularJsPage;
import com.unisuper.test.uitest.angularjs.pages.ToDoMvcHomePage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class ToDoMvcSteps
{

    ToDoMvcHomePage      toDoHomePage;
    ToDoMvcAngularJsPage toDoMvcAngularJsPage;

    @Step
    public void opensHomePage()
    {
        toDoHomePage.open();
    }

    @Step
    public void navigateToAngularJsImplementation()
    {
        toDoHomePage.getLinkAngularJs().click();
        toDoMvcAngularJsPage = toDoHomePage.switchToPage(ToDoMvcAngularJsPage.class);
    }

    @Step
    public void typeToDoItemInInputbox(String toDoItem)
    {
        toDoMvcAngularJsPage.getNewToDoInputBox().clear();
        toDoMvcAngularJsPage.getNewToDoInputBox().sendKeys(toDoItem);
    }

    @Step
    public void pressEnterInToDoInputbox()
    {
        toDoMvcAngularJsPage.getNewToDoInputBox().sendKeys(Keys.RETURN);
    }

    @Step
    public void addToDoItem(String toDoItem)
    {
        typeToDoItemInInputbox(toDoItem);
        pressEnterInToDoInputbox();
    }

    @Step
    public void validateToDoItemPresent(String toDoItem)
    {

        assertThat("TODO Item Found in the List :", toDoMvcAngularJsPage.getToDoList().contains(toDoItem), is(equalTo(true)));
    }

    @Step
    public void updateToDoItem(String toDoItemOld, String toDoItemNew)
    {
        /* Find the Label and input Box, double click on label */
        WebElementFacade labelElement = toDoMvcAngularJsPage.getToDoRowElement(toDoItemOld, ToDoMvcAngularJsPage.TODO_LABLE);
        WebElementFacade inputElement = toDoMvcAngularJsPage.getToDoRowElement(toDoItemOld, ToDoMvcAngularJsPage.TODO_INPUT);
        Actions action = new Actions(toDoMvcAngularJsPage.getDriver());
        action.doubleClick(labelElement).perform();

        /* Now update with new value of TODO item */
        inputElement.clear();
        inputElement.sendKeys(toDoItemNew);
        inputElement.sendKeys(Keys.RETURN);

    }

    @Step
    public void markItemCompleted(String toDoItem)
    {
        toDoMvcAngularJsPage.getToDoRowElement(toDoItem, ToDoMvcAngularJsPage.TODO_COMPLETE_TOGGLE).click();
    }

    @Step
    public void verifyItemCompleted(String toDoItem)
    {
        assertThat("ToDo Item is Strike through :",
                toDoMvcAngularJsPage.getToDoRowElement(toDoItem, ToDoMvcAngularJsPage.TODO_LABLE).getCssValue("text-decoration"),
                containsString("line-through"));
    }

    @Step
    public void verifyItemActive(String toDoItem)
    {
        assertThat("ToDo Item is Strike through :",
                toDoMvcAngularJsPage.getToDoRowElement(toDoItem, ToDoMvcAngularJsPage.TODO_LABLE).getCssValue("text-decoration"),
                not(containsString("line-through")));
    }
}