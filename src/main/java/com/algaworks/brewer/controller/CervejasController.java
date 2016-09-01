package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.brewer.model.Cerveja;

/**
 * Controlador de Cervejas. Utilizado para buscar o pacote onde as classes de controller estar&atilde;o. N&atilde;o apagar
 *
 */
@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo") // O que o usuário passa na URL
	public String novo() {
		return "cerveja/CadastroCerveja"; // pagina HTML que sera devolvida para o usuario
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(" >>>> Tem erros sim");
		}

		System.out.println(" >>>>>> sku: " + cerveja.getSku());
		System.out.println(" >>>>>> nome: " + cerveja.getNome());
		return "cerveja/CadastroCerveja";
	}

}
