package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Editora;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.EditoraService;
import br.com.caelum.livraria.service.LivroService;

@Model
public class LivroBean {
	
	private Integer autorId;
	private Integer editoraId;
	
	@Inject
	private Livro livro;
	@Inject
	private LivroService livroService;
	@Inject
	private AutorService autorService;
	@Inject
	private EditoraService editoraService;

	public void cadastra() {
		Autor autor = this.autorService.buscaPelaId(this.autorId);
		Editora editora = this.editoraService.buscaPelaId(this.editoraId);
		this.livro.setAutor(autor);
		this.livro.setEditora(editora);
		this.livroService.salva(livro);
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
	
	public List<Editora> getEditoras() {
		return editoraService.todasEditoras();
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public Integer getEditoraId() {
		return editoraId;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Livro> getLivros() {
		return this.livroService.todosLivros();
	}
}
