package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.Estilos;

/**
 * Controlador de Cervejas. Utilizado para buscar o pacote onde as classes de controller estar&atilde;o. N&atilde;o apagar
 *
 */
@Controller
public class CervejasController {

	@Autowired
	private Estilos estilos;

	@RequestMapping("/cervejas/novo") // O que o usuário passa na URL
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());

		return mv; // pagina HTML que sera devolvida para o usuario
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(cerveja);
		}

		//Salva no banco de dados
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		System.out.println(" >>>>>> sku: " + cerveja.getSku());
		System.out.println(" >>>>>> nome: " + cerveja.getNome());
		System.out.println(" >>>>>> descricao: " + cerveja.getDescricao());
		return new ModelAndView("redirect:/cervejas/novo"); // Em redirect usa a URL e nao o nome da View (html na pasta template)
	}

}
