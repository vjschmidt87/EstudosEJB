package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroService {
		

	@Inject
	private LivroDao dao;

	public void salva(Livro livro) {
		this.dao.salva(livro);
	}
	
	public List<Livro> todosLivros() {
		return dao.todosLivros();
	}

}
