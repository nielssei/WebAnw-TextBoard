package edu.fra.uas.text.service;

import java.util.List;

import edu.fra.uas.text.model.Text;

// Interface zum Zugriff auf Service Methoden durch Controller. Methoden werden implementiert in TextServiceImpl.
public interface TextService {
		
	List<Text> getAllTexts();
	
	Text saveText(Text text);
	
	Text getTextById(Long Id);
	
	Text updateText(Text Text);
	
	void deleteTextById(Long Id);
}
