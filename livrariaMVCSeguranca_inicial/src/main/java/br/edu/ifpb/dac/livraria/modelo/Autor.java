package br.edu.ifpb.dac.livraria.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
public class Autor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 3, max = 100)
	private String nome;
	@Email(message = "{email}")
	private String email;
	
	@ManyToMany(mappedBy="autores")
	private List<Livro> livros;
	
	public Autor() {
	}

	public Autor(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}