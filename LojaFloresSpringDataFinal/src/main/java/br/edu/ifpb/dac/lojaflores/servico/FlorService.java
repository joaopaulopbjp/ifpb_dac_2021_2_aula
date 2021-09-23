package br.edu.ifpb.dac.lojaflores.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.lojaflores.modelo.Flor;
import br.edu.ifpb.dac.lojaflores.repositorio.FlorRepository;

@Service
public class FlorService {
	
	@Autowired
	private FlorRepository repositorioFlor;
	
	public void salvar(Flor produto) {
		repositorioFlor.save(produto);
	}
	
	public Page<Flor> pesquisarTodasFlores(String campoOrdenacao, Sort.Direction direcaoOrdenacao, Integer numPagina){
		Sort ordenacao = Sort.by(direcaoOrdenacao, campoOrdenacao);
		return repositorioFlor.findAll(PageRequest.of(--numPagina, 2, ordenacao));
	}
	
	public List<Flor> pesquisaFloresPelaCor(String cor){
		return (List<Flor>) repositorioFlor.pesquisarCorPetalas(cor);
	}
}
