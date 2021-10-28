package br.edu.ifpb.dac.hello.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifpb.dac.hello.modelo.dto.HelloUsuario;

@Controller
public class HelloWorldFormulario {

	@GetMapping("/oiForm")
	public String exibirFormulario(Model model) {
		
		model.addAttribute("helloUsuario", new HelloUsuario());
		
		return "helloForm";
	}
	
	@PostMapping("/oiFormProcessa")
	public String processarFormulario(@ModelAttribute HelloUsuario usuario, Model model) {
		
		model.addAttribute("nomeUsuario", usuario.getNome());
		
		return "helloworld";
	}
}
