package com.screenply.ui;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheTodoItems implements Question<List<String>>{

	@Override
	public List<String> answeredBy(Actor actor) {
		return Text.of(SearchBox.text)       
	            .viewedBy(actor)     
	            .asList();   
	}
	
	
	
	public static Question<List<String>> displayed() {     
        return new TheTodoItems();
    }
	
	

}
