package br.edu.ifpb.dac.livraria.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.livraria.modelo.Livro;
import br.edu.ifpb.dac.livraria.repositorio.LivroRepositorio;

@Service
public class LivroService {

	@Autowired
	private LivroRepositorio livroRepositorio;
	
	public List<Livro> listaLivros(){
		return (List<Livro>) livroRepositorio.findAll();
	}
	
	public void adicionaLivro(Livro l) {
		livroRepositorio.save(l);
	}

	public Livro buscaPeloId(Integer id) {
		return livroRepositorio.findById(id).get();
	}

	public void atualizaLivro(Integer id, Livro livro) {
		Optional<Livro> livroRecuperado = livroRepositorio.findById(id);
		if(livroRecuperado.isPresent()) {
			Livro l = livroRecuperado.get();
			l.setTitulo(livro.getTitulo());
			l.setIsbn(livro.getIsbn());
			l.setPreco(livro.getPreco());
			
			livroRepositorio.save(l);
		}
		
	}
}
