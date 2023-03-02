package edu.fra.uas.text.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.text.model.Text;
import edu.fra.uas.text.service.TextService;

// REST Schnittstelle, um Daten auch ohne Frontend abzufragen und zu verarbeiten
@RestController
@RequestMapping("/api")
public class TextRestController {
	
	@Autowired
	private TextService textService;
	
	// Gibt alle Attribute aller Texte als JSON zurück
	@GetMapping
	public ResponseEntity<List<Text>> getAllTexts() {
		    
		List<Text> allTexts =  textService.getAllTexts();
		return new ResponseEntity<>(allTexts, HttpStatus.OK);
			
	}
	
	// Gibt alle Attribute eines Textes als JSON zurück
	@GetMapping("/{id}")
	public ResponseEntity<Text> getTextById(@PathVariable Long id) {
		   
		Text text =  textService.getTextById(id);
		return new ResponseEntity<>(text, HttpStatus.OK);
			
	}
	// Möglichkeit, neuen Text anzulegen. Liest aus HTTP-Request Body aus.
	@PostMapping
	public ResponseEntity<Text> createText(@RequestBody Text text) {
	    
		textService.saveText(text);
		return new ResponseEntity<>(text, HttpStatus.CREATED);
			
	}
	// Handlet Requests zur Bearbeitung einzelner Texte. Liest Text ID aus URL, Atribute aus Body
	PutMapping("/{id}")
	public ResponseEntity<Text> editText(@RequestBody Text text, @PathVariable Long id) {

		Text existingText = textService.getTextById(id);
		
		existingText.setId(id);
		existingText.setTitle(text.getTitle());
		existingText.setContent(text.getContent());
		
		textService.saveText(existingText);
		
		return new ResponseEntity<>(text, HttpStatus.OK);
			
	}
	// Handlet Requests zur Löschung einzelner Texte
	@DeleteMapping("/{id}")
	public ResponseEntity<Text> deleteById(@PathVariable("id") Long id) {
	
		Text deletedText = textService.getTextById(id);
		textService.deleteTextById(id);
		return new ResponseEntity<>(deletedText, HttpStatus.OK);
    	
	}
}

