package com.algaworks.brewer.controller.page;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageWrapper<T> {

	private Page<T> pagina;

	public PageWrapper(Page<T> pagina) {
		this.pagina = pagina;
	}

	public List<T> getConteudo() {
		return pagina.getContent();
	}

	public boolean isVazia() {
		return pagina.getContent().isEmpty();
	}

	public int getAtual() {
		return pagina.getNumber();
	}

	public int getTotal() {
		return pagina.getTotalPages();
	}

	public boolean isPrimeira() {
		return pagina.isFirst();
	}

	public boolean isUltima() {
		return pagina.isLast();
	}

}
