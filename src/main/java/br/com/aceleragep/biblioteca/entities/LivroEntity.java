package br.com.aceleragep.biblioteca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_livros")
public class LivroEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "ano_lancamento", nullable = false, columnDefinition = "int(4)")
	private Integer anoLancamento;
	
	@ManyToMany
	@JoinTable(name = "tb_livros_autores",
	joinColumns = @JoinColumn(name = "livro_id"),
	inverseJoinColumns = @JoinColumn(name = "autor_id"))
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
