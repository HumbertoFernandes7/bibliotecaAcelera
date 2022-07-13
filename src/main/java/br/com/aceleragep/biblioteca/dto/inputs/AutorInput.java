package br.com.aceleragep.biblioteca.dto.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AutorInput {
	
	@NotBlank
	@Length(min = 1, max = 100)
	private String nome;
	
	@NotBlank
	@Length(min = 1, max = 1000)
	private String biografia;

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
