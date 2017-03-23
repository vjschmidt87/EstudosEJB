package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

	public List<Livro> getLivrosPeloNome(String nome) {

		System.out.println("LivrariaWS: procurando pelo título: " + nome);

		// aqui usaremos o DAO para executar a pesquisa

		return null;
	}
}