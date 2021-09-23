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
	
	public void salvar(Flor produto) {
	}
	
	public Page<Flor> pesquisarTodasFlores(String campoOrdenacao, Sort.Direction direcaoOrdenacao, Integer numPagina){

	}
	
	public List<Flor> pesquisaFloresPelaCor(String cor){
		
	}
}
