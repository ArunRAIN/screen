package com.screenply.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.GetElementText;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.screenply.ui.SearchBox;
import com.thoughtworks.selenium.webdriven.commands.GetText;

public class Search implements Task {

    private final String searchTerm;

    protected Search(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                     .into(SearchBox.SEARCH_FIELD)
                     .thenHit(ENTER)
                                         
        );
        
    }

    public static Search forTheTerm(String searchTerm) {
        return instrumented(Search.class, searchTerm);
    }

}
