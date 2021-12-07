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
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifpb.dac.livraria.modelo.Autor;
import br.edu.ifpb.dac.livraria.modelo.Livro;
import br.edu.ifpb.dac.livraria.modelo.Usuario;
import br.edu.ifpb.dac.livraria.repositorio.LivroRepositorio;
import br.edu.ifpb.dac.livraria.servico.AutorService;
import br.edu.ifpb.dac.livraria.servico.LivroService;

@RestController
@RequestMapping("/autores")
public class AutoresController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/publico/lista")
	public List<Autor> listar(/*, @AuthenticationPrincipal Usuario usuario*/) {
		System.out.println("AutorController - Lista de autores");
		
		List<Autor> listaAutores = autorService.listaAutores();
		
//		model.addAttribute("autores", listaAutores);
//		model.addAttribute("usuario", usuario);
//		model.addAttribute("usuario", new Usuario());

		return listaAutores;
	}
	

	@GetMapping("/publico/lista/{id}")
	public Autor detalhaLivro(@PathVariable("id") Integer id) {
		
		return autorService.buscaPeloId(id);
	}

	
	@PostMapping("/protegido/adicionaAutor")
	@ResponseStatus(code = HttpStatus.CREATED,reason = "Autor criado com sucesso")
	public void adicionaAutor(@Valid @RequestBody Autor autor, BindingResult result, Model modelo) {
		System.out.println("AutorController - Adiciona Autor");

		if(!result.hasErrors()) {
			System.out.println("AutorController - Adiciona Autor - Autor cadastrado com sucesso");

			autorService.adicionaAutor(autor);
		}else {

			System.out.println("AutorController - Adiciona Autor - tem erros de validação");

			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, result.toString());
		}
	}
	


}
