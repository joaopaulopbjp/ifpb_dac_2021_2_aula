package br.edu.ifpb.dac.livraria.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.livraria.modelo.Autor;
import br.edu.ifpb.dac.livraria.modelo.Livro;
import br.edu.ifpb.dac.livraria.modelo.Usuario;
import br.edu.ifpb.dac.livraria.repositorio.LivroRepositorio;
import br.edu.ifpb.dac.livraria.servico.AutorService;
import br.edu.ifpb.dac.livraria.servico.LivroService;

@Controller
@RequestMapping("/autores")
public class AutoresController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/publico/lista")
	public String listar(Model model, @AuthenticationPrincipal Usuario usuario) {
		System.out.println("AutorController - Lista de autores");
		
		List<Autor> listaAutores = autorService.listaAutores();
		
		model.addAttribute("autores", listaAutores);
		model.addAttribute("usuario", usuario);

		return "/autores/autores";
	}
	
	@GetMapping("/protegido/home")
	public String homeAdmin(Model model, @AuthenticationPrincipal Usuario usuario) {
		System.out.println("AutorController - Home Admin");
		
		List<Autor> listaAutores = autorService.listaAutores();
		
		model.addAttribute("autores", listaAutores);
		model.addAttribute("usuario", usuario);

		return "/autores/protegido/homeadmin";
	}

	
	public String detalhaLivro(Integer id) {
		return "/livros/livro";
	}
	
	@GetMapping("/protegido/form")
	public String mostrarForm(Model model,@AuthenticationPrincipal Usuario usuario ) {
		System.out.println("AutorController - Mostrando formulario");
		
		model.addAttribute("autor", new Autor());
		model.addAttribute("usuario", usuario);

		return "/autores/protegido/formAutor";
	}
	
	@PostMapping("/protegido/adicionaAutor")
	public String adicionaAutor(@Valid @ModelAttribute("autor") Autor autor, BindingResult result, Model modelo) {
		System.out.println("AutorController - Adiciona Autor");
		
		if(!result.hasErrors()) {
			System.out.println("AutorController - Adiciona Autor - Autor cadastrado com sucesso");
			
			autorService.adicionaAutor(autor);
			return "redirect:/autores/lista";
		}
		
		System.out.println("AutorController - Adiciona Autor - tem erros de valida????o");
		
		return "/autores/formAutor";
	}
	
	public void atualizaLivro(Livro livro, Integer id) {
		
//		autorService.atualizaLivro(id,livro);
	}


}
