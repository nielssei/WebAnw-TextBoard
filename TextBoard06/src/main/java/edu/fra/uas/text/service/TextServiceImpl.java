package edu.fra.uas.text.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.text.model.Text;
import edu.fra.uas.text.repository.TextRepository;

@Service
public class TextServiceImpl implements TextService {
	
	private static final Logger log = LoggerFactory.getLogger(TextService.class);
	
	@Autowired
	private TextRepository textRepository;
	
	// Methode um alle Texte abzufragen
	@Override
	public List<Text> getAllTexts() {
		log.debug("GET -> All");
		return textRepository.findAll();
	}
	
	// Methode um einzelne Texte zu speichern
	@Override
	public Text saveText(Text text ) {
		log.debug("POST -> " + text.getId());
		return textRepository.save(text);
	}
	
	// Methode um einzelne Texte abzufragen
	@Override
	public Text getTextById(Long id) {
		Text text = textRepository.findById(id).get();
		log.debug("GET -> ID: " + text.getId());
		return textRepository.findById(id).get();
	}
	// Methode um geänderte Texte zu speichern
	@Override
	public Text updateText(Text text) {
		log.debug("POST -> Update -> ID: " + text.getId());
		return textRepository.save(text);
	}
	// Methode um einzelne Texte zu löschen
	@Override
	public void deleteTextById(Long id) {
		Text text = textRepository.findById(id).get();
		log.debug("DELETE -> ID: " + text.getId());
		textRepository.deleteById(id);
	}
	
}
