package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Editora;
import br.com.caelum.livraria.service.EditoraService;

@Model
public class EditoraBean {
	
	@Inject
	Editora editora;
	
	@Inject
	EditoraService service;
	
	public Editora getEditora() {
		return editora;
	}
	
	public void cadastra() {
		this.service.adciona(editora);
		editora = new Editora();
	}
	
	public List<Editora> getEditoras() {
		return this.service.todasEditoras();
	}
}
