package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager em;
	
	public void salva(Livro livro) {
		em.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
	}
	
	public List<Livro> getLivrosPeloNome(String nome) {

        TypedQuery<Livro> query = this.em.createQuery(
                "select l from Livro l " + 
                "where l.titulo like :pTitulo", Livro.class);
        query.setParameter("pTitulo", "%" + nome + "%");

        return query.getResultList();
    }
	
	public List<Livro> getLivrosPeloAutor(String nome) {

        TypedQuery<Livro> query = this.em.createQuery(
                "select l from Livro l " + 
                "where l.autor.id = (select a.id from Autor a " +
                "where a.nome = :pNome)", Livro.class);
        query.setParameter("pNome", nome);

        return query.getResultList();
    }
	
	public List<Livro> getLivrosPelaEditora(String nome) {

        TypedQuery<Livro> query = this.em.createQuery(
                "select l from Livro l " + 
                "where l.editora.id = (select e.id from Editora e " +
                "where e.nome = :pNome)", Livro.class);
        query.setParameter("pNome", nome);

        return query.getResultList();
    }
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("LivroDAO criado");
	}
}
