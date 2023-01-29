package edu.fra.uas.text.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.fra.uas.text.model.Text;
import edu.fra.uas.text.service.TextService;

@Controller
public class TextController {
	
	@Autowired
	private TextService textService;
	
	@GetMapping("/texts")
	public String listTexts(Model model) {
		
		model.addAttribute("texts", textService.getAllTexts());
		return "texts";
	}
	
	@GetMapping("/texts/new")
	public String createTextForm(Model model) {
		
		Text text = new Text();
		model.addAttribute("text", text);
		return "create_text";
		
	}
	
	@PostMapping("/texts")
	public String saveText(@ModelAttribute("text") Text text) {
		textService.saveText(text);
		return "redirect:/texts";
		
	}
	
	@GetMapping("/texts/edit/{id}")
	public String editTextForm(@PathVariable Long id, Model model) {
		model.addAttribute("text", textService.getTextById(id));
		return "edit_text";	
	}

	@PostMapping("/texts/{id}")
	public String updateStudent(@PathVariable Long id,
				@ModelAttribute("text") Text text, Model model) {
		
		Text existingText = textService.getTextById(id);
		existingText.setId(id);
		existingText.setTitle(text.getTitle());
		existingText.setContent(text.getContent());
		
		textService.updateText(existingText);
		return "redirect:/texts";
	}
	
	@GetMapping("texts/{id}")
	public String deleteStudent(@PathVariable Long id) {
		textService.deleteTextById(id);
		return "redirect:/texts";
	}
}
