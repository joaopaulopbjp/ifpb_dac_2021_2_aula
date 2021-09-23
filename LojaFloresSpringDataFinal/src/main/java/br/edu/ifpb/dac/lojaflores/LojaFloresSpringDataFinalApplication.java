package br.edu.ifpb.dac.lojaflores;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.edu.ifpb.dac.lojaflores.modelo.Flor;
import br.edu.ifpb.dac.lojaflores.servico.FlorService;

@SpringBootApplication
public class LojaFloresSpringDataFinalApplication implements CommandLineRunner{

	private FlorService servicoProduto;
	
	public LojaFloresSpringDataFinalApplication(FlorService servicoProduto) {
		this.servicoProduto = servicoProduto;
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaFloresSpringDataFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean con = true;

		Scanner input = new Scanner(System.in);
		
		//Menu
		while(con) {
			
			System.out.println(
					"0 - Sair"
					+"\n1 - Cadastrar Flor"
					+ "\n2 - Consultar todas as Flores"
					+ "\n3 - Consultar Flores pela cor"
					);
			
			int opcao = Integer.parseInt(input.nextLine());
			
			switch(opcao) {
				
				case 1: 
					Flor novaFlor = new Flor();
					System.out.println("Cadastro de Flor: \n");
					
					System.out.println("Nome: \n");
					String nome = input.nextLine();
					
					System.out.println("Cor das pétalas: \n");
					String cor = input.nextLine();
					
					System.out.println("Preço: \n");
					String precoStr = input.nextLine();
					BigDecimal preco = new BigDecimal(precoStr);
					
					novaFlor.setNome(nome);
					novaFlor.setCorPetalas(cor);
					novaFlor.setPreco(preco);
					
					servicoProduto.salvar(novaFlor);
					break;
				case 2:
					System.out.println("Lista de todos os produtos: \n");
					
					System.out.println("Deseja ordenar por qual campo? \n");
					String campoOrdenar = input.nextLine();
					System.out.println("Crescente - 1 ou Decrescente - 2 \n");
					Integer direcaoEscolha = Integer.parseInt(input.nextLine());
					Sort.Direction direcaoOrdenar = Sort.Direction.ASC;
					switch (direcaoEscolha) {
						case 1:
							direcaoOrdenar = Sort.Direction.ASC;
							break;
					
						case 2:
							direcaoOrdenar = Sort.Direction.DESC;
							break;
						default:
							break;
					}
					
					System.out.println("Qual página? \n");
					Integer numPagina = Integer.parseInt(input.nextLine());
					
					Page<Flor> produtos = servicoProduto.pesquisarTodasFlores(campoOrdenar, direcaoOrdenar,numPagina); 
					for (Flor produto : produtos) {
						System.out.println(produto +"\n");
					}
					break;
				case 3:
					System.out.println("Flores pela cor: \n");
					System.out.println("Qual a cor? \n");
					String corPesquisa = input.nextLine(); 
					List<Flor> floresPelaCor = servicoProduto.pesquisaFloresPelaCor(corPesquisa); 
					for (Flor produto : floresPelaCor) {
						System.out.println(produto +"\n");
					}
					break;
				default:
					con=false;
			}

		
		}

	}
}
