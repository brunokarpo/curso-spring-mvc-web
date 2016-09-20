package com.algaworks.brewer.service.event.cerveja;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CervejaListener {

	@EventListener(condition = "#event.temFoto()")
	public void cervejaSalva(CervejaSalvaEvent event) {
		System.out.println("Tem foto sim: " + event.getCerveja().getFoto());
	}

}
