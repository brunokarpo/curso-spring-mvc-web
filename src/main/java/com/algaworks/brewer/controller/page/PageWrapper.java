package com.algaworks.brewer.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class PageWrapper<T> {

	private Page<T> pagina;
	private UriComponentsBuilder uriBuilder;

	public PageWrapper(Page<T> pagina, HttpServletRequest httpServletResquest) {
		this.pagina = pagina;
		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletResquest);
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

	public String urlParaPagina(int pagina) {
		return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toString();
	}

}
