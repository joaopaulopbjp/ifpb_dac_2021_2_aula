package br.edu.ifpb.dac.livraria.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.edu.ifpb.dac.livraria.repositorio.LivroRepositorio;
import br.edu.ifpb.dac.livraria.servico.AutorService;
import br.edu.ifpb.dac.livraria.servico.LivroService;

@Controller
@RequestMapping("/livros")
public class LivrosController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private AutorService autorService;

	@GetMapping("/lista")
	public String listar(Model model) {
		List<Livro> listaLivros = livroService.listaLivros();
		
		model.addAttribute("livros", listaLivros);

		return "/livros/livros";
	}
	
	@GetMapping("/form")
	public String mostrarForm(Model model) {
		
		model.addAttribute("livro", new Livro());
		model.addAttribute("autores", autorService.listaAutores());
		

		return "/livros/formLivro";
	}

	public String detalhaLivro(Integer id) {
		return "/livros/livro";
	}
	
	@PostMapping("/adicionaLivro")
	public String adicionaLivro(@ModelAttribute("livro") Livro livro,  Model modelo) {
		
		livroService.adicionaLivro(livro);
		return "redirect:/livros/lista";
	}
	
	public void atualizaLivro(Livro livro, Integer id) {
		
		livroService.atualizaLivro(id,livro);
	}


}
