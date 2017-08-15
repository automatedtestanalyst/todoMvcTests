package com.unisuper.test.uitest.angularjs.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ToDoMvcAngularJsPage extends PageObject
{

    public final static String TODO_INPUT           = "//*[@id='todo-list']/li[%s]/form/input";
    public final static String TODO_LABLE           = "//*[@id='todo-list']/li[%s]/div/label";
    public final static String TODO_COMPLETE_TOGGLE = "//*[@id='todo-list']/li[%s]/div/input";

    @FindBy(id = "new-todo")
    private WebElementFacade   newToDoInputBox;

    public WebElementFacade getNewToDoInputBox()
    {
        return newToDoInputBox;
    }

    public List<String> getToDoList()
    {
        List<WebElementFacade> elements = findAll(".view");
        List<String> toDoList = new ArrayList<>();

        for (WebElementFacade element : elements)
        {
            toDoList.add(element.getText());
        }
        return toDoList;
    }

    public WebElementFacade getToDoRowElement(String toDoItem, String elementType)
    {
        WebElementFacade element = null;
        int index = findToDoItemIndex(toDoItem);
        if (index != 0)
        {
            element = findBy(String.format(elementType, index));
        }
        return element;
    }

    private int findToDoItemIndex(String toDoItem)
    {
        List<WebElementFacade> elements = findAll(".view");
        for (int index = 0; index < elements.size(); index++)
        {
            if (elements.get(index).containsText(toDoItem))
            {
                return index + 1;
            }
        }
        return 0;
    }

}