package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.EditoraDao;
import br.com.caelum.livraria.modelo.Editora;

@Stateless
public class EditoraService {

	@Inject
	EditoraDao dao;
	
	public void adciona(Editora editora) {
		dao.salva(editora);		
	}
	
	public List<Editora> todasEditoras() {
		return dao.todasEditoras();
	}
	
	public Editora buscaPelaId(final Integer autorId) {
		return this.dao.buscaPelaId(autorId);
	}
	
}
