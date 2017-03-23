package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Editora;

@Stateless
public class EditoraDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salva(Editora editora) {
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
		em.persist(editora);
	}
	
	public List<Editora> todasEditoras() {
		return em.createQuery("SELECT a FROM Editora a", Editora.class).getResultList();
	}

	public Editora buscaPelaId(Integer editoraId) {
		return em.find(Editora.class, editoraId);
	}
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("EditoraDAO criado");
	}
}
