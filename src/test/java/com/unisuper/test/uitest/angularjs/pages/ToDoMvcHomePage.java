package com.unisuper.test.uitest.angularjs.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://todomvc.com")
public class ToDoMvcHomePage extends PageObject
{

    @FindBy(css = "a[href='examples/angularjs']")
    private WebElementFacade linkAngularJs;

    public WebElementFacade getLinkAngularJs()
    {
        return linkAngularJs;
    }
}