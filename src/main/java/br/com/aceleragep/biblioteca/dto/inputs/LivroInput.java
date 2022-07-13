package br.com.aceleragep.biblioteca.dto.inputs;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class LivroInput {

	@NotBlank
	@Length(min = 1, max = 200)
	private String titulo;
	
	@NotNull @Digits(integer = 4, fraction = 0)
	private Integer anoLancamento;
	
	@Size(min = 1)
	private List<Long> autoresIds;
	
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
	public List<Long> getAutoresIds() {
		return autoresIds;
	}
	public void setAutoresIds(List<Long> autoresIds) {
		this.autoresIds = autoresIds;
	}

}
