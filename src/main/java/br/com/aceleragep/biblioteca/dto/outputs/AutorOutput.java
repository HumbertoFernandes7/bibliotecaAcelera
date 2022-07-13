package br.com.aceleragep.biblioteca.dto.outputs;

import lombok.Getter;
import lombok.Setter;

public class AutorOutput {
	
	private Long id;
	private String nome;
	private String biografia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	
}
