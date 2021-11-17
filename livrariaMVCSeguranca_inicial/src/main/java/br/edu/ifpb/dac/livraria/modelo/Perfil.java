	package br.edu.ifpb.dac.livraria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perfil{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomePerfil;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

}
