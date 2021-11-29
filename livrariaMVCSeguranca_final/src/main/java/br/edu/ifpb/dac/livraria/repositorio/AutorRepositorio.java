package br.edu.ifpb.dac.livraria.repositorio;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.livraria.modelo.Autor;


@Repository
public interface AutorRepositorio extends PagingAndSortingRepository<Autor ,Integer>{
}
