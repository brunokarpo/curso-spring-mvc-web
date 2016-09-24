package com.algaworks.brewer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "estado")
public class Estado extends Entidade {

	private static final long serialVersionUID = -1786433351307168147L;

	@NotEmpty(message = "O nome do estado é obrigatório")
	private String nome;

	@NotEmpty(message = "A sigla do estado é obrigatória")
	private String sigla;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
