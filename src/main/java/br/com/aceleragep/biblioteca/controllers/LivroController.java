package br.com.aceleragep.biblioteca.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aceleragep.biblioteca.config.ControllerConfig;
import br.com.aceleragep.biblioteca.converties.LivroConvert;
import br.com.aceleragep.biblioteca.dto.inputs.LivroInput;
import br.com.aceleragep.biblioteca.dto.outputs.LivroOutput;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@Autowired
	LivroConvert livroConvert;

	@GetMapping
	public Page<LivroOutput> listarTodos(@PageableDefault(page = 0, size = 5, direction = Direction.ASC) Pageable paginacao) {
		Page<LivroEntity> livros = livroService.listarTodos(paginacao);
		return livroConvert.ListaEntityParaListaOutput(livros);
	}
	
	@GetMapping("/{autorId}")
	public LivroOutput buscaPorId(@PathVariable Long autorId) {
		LivroEntity livroEncontrado = livroService.buscaPorId(autorId);
		return livroConvert.entityParaOutput(livroEncontrado);
	}
	
	@PostMapping
	public ResponseEntity<LivroOutput> cadastrar(@Valid @RequestBody LivroInput livroInput, UriComponentsBuilder uriBuild){
		
		LivroEntity livroEntity = livroConvert.inputParaEntity(livroInput);
		LivroEntity livroSalvo = livroService.cadastrar(livroEntity);
		LivroOutput livroOutput = livroConvert.entityParaOutput(livroSalvo);
		
		URI uri = uriBuild.path(ControllerConfig.PRE_URL + "/livros/{id}").buildAndExpand(livroSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(livroOutput);
		
	}
	
	@PutMapping("/{autorId}")
	public ResponseEntity<LivroOutput> atualizar(@PathVariable Long autorId, @Valid @RequestBody LivroInput livroAtualizadoInput) {
		LivroEntity livroEncontrado = livroService.buscaPorId(autorId);
		livroConvert.copiaInputParaEntity(livroEncontrado, livroAtualizadoInput);
		LivroEntity livroSalvo = livroService.atualizar(livroEncontrado);
		LivroOutput livroOutput = livroConvert.entityParaOutput(livroSalvo);
		
		return ResponseEntity.ok().body(livroOutput);
	}
	
	@DeleteMapping("/{autorId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long autorId) {
		LivroEntity livroEncontrado = livroService.buscaPorId(autorId);
		livroService.deletar(livroEncontrado);
	}
	
}
