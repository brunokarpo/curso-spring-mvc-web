package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de Cervejas. Utilizado para buscar o pacote onde as classes de controller estar&atilde;o. N&atilde;o apagar
 *
 */
@Controller
public class CervejasController {

	@RequestMapping("cervejas/novo") // O que o usuário passa na URL
	public String novo() {
		return "cerveja/CadastroCerveja"; // pagina HTML que sera devolvida para o usuario
	}

}
