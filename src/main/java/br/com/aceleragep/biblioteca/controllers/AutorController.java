package br.com.aceleragep.biblioteca.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aceleragep.biblioteca.config.ControllerConfig;
import br.com.aceleragep.biblioteca.converties.AutorConvert;
import br.com.aceleragep.biblioteca.converties.LivroConvert;
import br.com.aceleragep.biblioteca.dto.inputs.AutorInput;
import br.com.aceleragep.biblioteca.dto.outputs.AutorOutput;
import br.com.aceleragep.biblioteca.dto.outputs.LivroSemAutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.services.AutorService;
import br.com.aceleragep.biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/autores")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@Autowired
	AutorConvert autorConvert;
	
	@Autowired
	LivroConvert livroConvert;
	
	@Autowired
	LivroService livroService;
	
	//Lista todos
	@GetMapping
	public Page<AutorOutput> listarTodos(@PageableDefault(page = 0, size = 5, direction = Direction.ASC) Pageable paginacao){
		Page<AutorEntity> autores = autorService.listarTodos(paginacao);
		return autorConvert.ListaEntityParaListaOutput(autores);
	}
	
	//Busca por Id
	@GetMapping("/{autorId}")
	public AutorOutput buscaPorId(@PathVariable Long autorId) {
		AutorEntity autorEncontrado = autorService.buscaPorId(autorId);
		return autorConvert.entityParaOutput(autorEncontrado);
	}
	
	//Cadastrar
	@PostMapping
	public ResponseEntity<AutorOutput> cadastrar(@Valid @RequestBody AutorInput autorInput, UriComponentsBuilder uriBuild) {
		AutorEntity autorEntity = autorConvert.inputParaEntity(autorInput);
		AutorEntity autorSalvo = autorService.cadastrar(autorEntity);
		AutorOutput autorOutput = autorConvert.entityParaOutput(autorSalvo);
		
		URI uri = uriBuild.path(ControllerConfig.PRE_URL + "autores/{id}").buildAndExpand(autorSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(autorOutput);
	}
	
	//Atualizar
	@PutMapping("/{autorId}")
	public ResponseEntity<AutorOutput> atualizar(@PathVariable Long autorId, @Valid @RequestBody AutorInput autorAtualizacaoInput) {
		AutorEntity autorEncontrado = autorService.buscaPorId(autorId);
		autorConvert.copiaInputParaEntity(autorEncontrado, autorAtualizacaoInput);
		AutorEntity autorSalvo = autorService.atualizar(autorEncontrado);
		AutorOutput autorOutput = autorConvert.entityParaOutput(autorSalvo);
		return ResponseEntity.ok().body(autorOutput);
	}
	
	//Lista os livros pelo id do autor
	@GetMapping("/{autorId}/livros")
	public Page<LivroSemAutorOutput> buscaLivroPeloIdAutor(@PathVariable Long autorId, @PageableDefault(page = 0, size = 5, direction = Direction.ASC) Pageable paginacao) {
		autorService.buscaPorId(autorId);
		Page<LivroEntity> listaLivrosComAutor = livroService.buscaLivroPeloIdAutor(autorId, paginacao);
		return livroConvert.listaLivrosComAutorParaListaLivrosSemAutor(listaLivrosComAutor);
	}
}
