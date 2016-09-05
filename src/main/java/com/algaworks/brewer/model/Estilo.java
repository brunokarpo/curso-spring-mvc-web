package com.algaworks.brewer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estilo")
public class Estilo extends Entidade {

	private static final long serialVersionUID = 1773634308105458149L;

	private String nome;

	@OneToMany(mappedBy = "estilo")
	private List<Cerveja> cervejas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}



}
