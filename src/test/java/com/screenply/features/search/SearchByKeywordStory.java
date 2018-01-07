package com.screenply.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.lift.match.DisplayedMatcher;

import com.screenply.tasks.OpenTheApplication;
import com.screenply.tasks.Search;
import com.screenply.ui.SearchBox;
import com.screenply.ui.TheTodoItems;
import com.screenply.ui.Thtodoitems2;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import gherkin.lexer.Is;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test()
    public void search_results_should_show_the_search_term_in_the_text1() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Search.forTheTerm("java video"));
       
        then(anna).should(IsElementPresent(Thtodoitems2.displayed()));
        	
        
        then(anna).should(seeThat(TheTodoItems.displayed(), hasItem("java video")));

    }
    
   
	private Consequence IsElementPresent(Question<List<String>> displayed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test()
    public void search_results_should_show_the_search_term_in_the_text() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Search.forTheTerm("java tutorial"));
       
        //then(anna).should(eventually(seeThat(TheWebPage.title(),containsString("Oracle.com Search"))));
        	
        
        then(anna).should(seeThat(TheTodoItems.displayed(), hasItem("java tutorial")));

    }
    
}