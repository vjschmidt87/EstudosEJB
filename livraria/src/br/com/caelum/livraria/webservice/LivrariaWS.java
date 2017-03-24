package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

	@Inject
	LivroDao livroDao;
	
	@WebResult(name="livro")
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome) {

		System.out.println("LivrariaWS: procurando pelo título: " + nome);

		return livroDao.getLivrosPeloNome(nome);
	}
	
	@WebResult(name="livro")
	public List<Livro> getLivrosDoAutor(@WebParam(name="autor") String nome) {

		System.out.println("LivrariaWS: procurando livros do autor " + nome);

		return livroDao.getLivrosPeloAutor(nome);
	}
	
	@WebResult(name="livro")
	public List<Livro> getLivrosDaEditora(@WebParam(name="editora") String nome) {

		System.out.println("LivrariaWS: procurando livros da editora " + nome);

		return livroDao.getLivrosPelaEditora(nome);
	}
}