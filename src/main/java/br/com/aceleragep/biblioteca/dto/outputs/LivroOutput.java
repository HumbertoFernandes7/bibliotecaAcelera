package br.com.aceleragep.biblioteca.dto.outputs;

import java.util.List;

import br.com.aceleragep.biblioteca.entities.AutorEntity;

public class LivroOutput {

	private Long id;
	private String titulo;
	private Integer anoLancamento;
	
	private List<AutorEntity> autores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public List<AutorEntity> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorEntity> autores) {
		this.autores = autores;
	}
}
