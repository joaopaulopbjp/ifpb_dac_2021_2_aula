package br.edu.ifpb.dac.lojaflores.repositorio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.lojaflores.modelo.Flor;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Long>{

	@Query("SELECT f FROM Flor f WHERE f.corPetalas LIKE %:cor%")
	public List<Flor> pesquisarCorPetalas(@Param("cor") String cor);
	
	public List<Flor> findByNome(String nome);
	
	public List<Flor> findByPrecoLessThanEqual(BigDecimal preco);
}
