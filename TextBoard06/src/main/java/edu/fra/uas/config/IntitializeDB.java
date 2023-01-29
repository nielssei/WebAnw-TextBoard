package edu.fra.uas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.text.model.Text;
import edu.fra.uas.text.service.TextService;
import jakarta.annotation.PostConstruct;

@Component
public class IntitializeDB {
	
	@Autowired
	private TextService textService;
	
	Text text1 = new Text();
	Text text2 = new Text();
	
	@PostConstruct
	public void init() {
		
		text1.setTitle("Bachelor Arbeit");
		text1.setContent("Diese Bachelorarbeit geht über Excel");
		
		text2.setTitle("Warum ChatGPT so gefährlich ist");
		text2.setContent("Keine Ahnung");
		
		textService.saveText(text1);
		textService.saveText(text2);
		
	}

}
