package br.edu.ifpb.dac.lojaflores.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String estado;
	
	private String descricao;
	
	private String corPetalas;
	
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCorPetalas() {
		return corPetalas;
	}

	public void setCorPetalas(String corPetalas) {
		this.corPetalas = corPetalas;
	}

	@Override
	public String toString() {
		return "Flor [nome=" + nome + ", estado=" + estado + ", descricao=" + descricao + ", corPetalas=" + corPetalas
				+ ", preco=" + preco + "]";
	}

	
	
}
