package br.edu.ifpb.dac.livraria.repositorio;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.livraria.modelo.Autor;
import br.edu.ifpb.dac.livraria.modelo.Usuario;


@Repository
public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario ,Integer>{
	
	public Optional<Usuario> findByEmail(String email);
}
