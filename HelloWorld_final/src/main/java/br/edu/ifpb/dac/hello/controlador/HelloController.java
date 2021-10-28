package br.edu.ifpb.dac.hello.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/oi")
	public ModelAndView dizerOi(@RequestParam(name="nome", required=false, defaultValue="World") String nome, 
			ModelAndView modelview) {
		modelview.setViewName("helloworld");
		modelview.addObject("nomeUsuario", nome);
		
		return modelview;
	}
	
	@PostMapping("/oi")
	public String dizerOiPost(@RequestParam(name="nome", required=false, defaultValue="World Post") String nome, 
			Model model) {
		
		model.addAttribute("nomeUsuario", nome);
		
		return "helloworld";
	}
	
	
}
