package br.com.aceleragep.biblioteca.dto.inputs;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.aceleragep.biblioteca.entities.AutorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@NotBlank
	@Length(min = 1, max = 200)
	private String titulo;
	
	@NotNull @Digits(integer = 4, fraction = 0)
	private Integer anoLancamento;
	
	@Size(min = 1)
	private List<Long> autoresIds;
}
