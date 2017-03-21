package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salva(Autor autor) {
		/** teste thread safe
		System.out.println("iniciou salvar Autor");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		banco.save(autor);
		System.out.println("encerrou salvar Autor");
		**/
		em.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return em.find(Autor.class, autorId);
	}
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("AutorDAO criado");
	}
	
}
