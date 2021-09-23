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
public class LojaFloresSpringDataInicialApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(LojaFloresSpringDataInicialApplication.class, args);
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
					System.out.println("Cadastro de Flor: \n");
					break;
				case 2:
					System.out.println("Lista de todos os produtos: \n");
					break;
				case 3:
					break;
				default:
					con=false;
			}

		
		}

	}
}
