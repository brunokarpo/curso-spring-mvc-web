package com.algaworks.brewer.repository.helper.estilo;

import java.util.List;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.filter.EstiloFilter;

public interface EstilosQueries {

	public List<Estilo> filtrar(EstiloFilter filter);

}
