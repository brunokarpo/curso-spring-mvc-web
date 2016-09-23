package com.algaworks.brewer.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class PageWrapper<T> {

	private Page<T> pagina;
	private UriComponentsBuilder uriBuilder;

	public PageWrapper(Page<T> pagina, HttpServletRequest httpServletResquest) {
		this.pagina = pagina;

		StringBuilder builder = new StringBuilder();
		builder.append(httpServletResquest.getRequestURL().toString());

		if(!StringUtils.isEmpty(httpServletResquest.getQueryString())) {
			builder.append("?");
			builder.append(httpServletResquest.getQueryString().replaceAll("\\+", "%20"));
		}

		this.uriBuilder = UriComponentsBuilder.fromHttpUrl(builder.toString());
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

	public String urlOrdenada(String propriedade) {
		UriComponentsBuilder uriBuilderOrder = UriComponentsBuilder
				.fromUriString(uriBuilder.build(true).encode().toUriString());

		String valorSort = String.format("%s,%s", propriedade, inverterDirecao(propriedade));

		return uriBuilderOrder.replaceQueryParam("sort", valorSort).build(true).encode().toString();
	}

	private String inverterDirecao(String propriedade) {
		String direcao = "asc";

		Order order = pagina.getSort() != null ? pagina.getSort().getOrderFor(propriedade) : null;
		if(order != null) {
			direcao = Sort.Direction.ASC.equals(order.getDirection()) ? "desc" : "asc";
		}

		return direcao;
	}

	public boolean descendente(String propriedade) {
		return inverterDirecao(propriedade).equals("asc") ? true : false;
	}

	public boolean ordenada(String propriedade) {
		Order order = pagina.getSort() != null ? pagina.getSort().getOrderFor(propriedade) : null;

		if(order == null) {
			return false;
		}

		return pagina.getSort().getOrderFor(propriedade) != null ? true : false;
	}

}
