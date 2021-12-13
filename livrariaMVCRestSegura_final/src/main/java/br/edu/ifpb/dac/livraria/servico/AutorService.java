package br.edu.ifpb.dac.livraria.servico;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.livraria.modelo.Autor;
import br.edu.ifpb.dac.livraria.repositorio.AutorRepositorio;

@Service
public class AutorService {

	@Autowired
	private AutorRepositorio autorRep;
	
	public List<Autor> listaAutores(){
		return (List<Autor>)autorRep.findAll();
	}

	public void adicionaAutor(Autor autor) {
		autorRep.save(autor);
		
	}

	public Autor buscaPeloId(Integer id) {
		return autorRep.findById(id).orElseThrow(() -> new EntityNotFoundException(Integer.toString(id)));
	}

}
