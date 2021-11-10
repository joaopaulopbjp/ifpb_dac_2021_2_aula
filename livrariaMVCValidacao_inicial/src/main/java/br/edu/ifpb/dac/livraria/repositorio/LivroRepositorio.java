package br.edu.ifpb.dac.livraria.repositorio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.livraria.modelo.Livro;


@Repository
public interface LivroRepositorio extends PagingAndSortingRepository<Livro,Integer>{

	List<Livro> findByTitulo(String titulo);
	Page<Livro> findByPrecoLessThan(BigDecimal preco, Pageable paginacao);
}
