package com.algaworks.brewer.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade extends Entidade {

	private static final long serialVersionUID = 768884000711082273L;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "codigo_estado")
	private Estado estado;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}



}
