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

@RestController
@RequestMapping("/api")
public class TextRestController {
	
	@Autowired
	private TextService textService;
	
	@GetMapping
	public ResponseEntity<List<Text>> getAllTexts() {
		    
		List<Text> allTexts =  textService.getAllTexts();
		return new ResponseEntity<>(allTexts, HttpStatus.OK);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Text> getTextById(@PathVariable Long id) {
		   
		Text text =  textService.getTextById(id);
		return new ResponseEntity<>(text, HttpStatus.OK);
			
	}
	
	@PostMapping
	public ResponseEntity<Text> createText(@RequestBody Text text) {
	    
		textService.saveText(text);
		return new ResponseEntity<>(text, HttpStatus.CREATED);
			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Text> editText(@RequestBody Text text, @PathVariable Long id) {

		Text existingText = textService.getTextById(id);
		
		existingText.setId(id);
		existingText.setTitle(text.getTitle());
		existingText.setContent(text.getContent());
		
		textService.saveText(existingText);
		
		return new ResponseEntity<>(text, HttpStatus.OK);
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Text> deleteById(@PathVariable("id") Long id) {
	
		Text deletedText = textService.getTextById(id);
		textService.deleteTextById(id);
		return new ResponseEntity<>(deletedText, HttpStatus.OK);
    	
	}
}

