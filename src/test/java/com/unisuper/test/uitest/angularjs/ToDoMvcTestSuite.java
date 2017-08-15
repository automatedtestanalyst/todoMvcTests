package com.unisuper.test.uitest.angularjs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/todomvc/ToDoListOperations.feature")
public class ToDoMvcTestSuite
{
}
