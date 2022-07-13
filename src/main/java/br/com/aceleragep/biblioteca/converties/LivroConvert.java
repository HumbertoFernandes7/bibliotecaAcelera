package br.com.aceleragep.biblioteca.converties;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.aceleragep.biblioteca.dto.inputs.LivroInput;
import br.com.aceleragep.biblioteca.dto.outputs.LivroOutput;
import br.com.aceleragep.biblioteca.dto.outputs.LivroSemAutorOutput;
import br.com.aceleragep.biblioteca.entities.LivroEntity;

@Component
public class LivroConvert {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AutorConvert autorConvert;

	public Page<LivroOutput> ListaEntityParaListaOutput(Page<LivroEntity> livros) {
		return livros.map(this::entityParaOutput);
	}
	
	public LivroOutput entityParaOutput(LivroEntity livros) {
		return modelMapper.map(livros, LivroOutput.class);
	}
	
	public LivroSemAutorOutput livroSemAutorParaOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroSemAutorOutput.class);
	}	
	
	public LivroEntity inputParaEntity(LivroInput livroInput) {
		
		LivroEntity livroEntity =  modelMapper.map(livroInput, LivroEntity.class);
		livroEntity.setAutores(autorConvert.longParaEntity(livroInput.getAutoresIds()));
		return livroEntity;
	}
	
	
	public void copiaInputParaEntity(LivroEntity livroEncontrado, LivroInput livroAtualizacaoInput) {
		modelMapper.map(livroAtualizacaoInput, livroEncontrado);
		livroEncontrado.setAutores(autorConvert.longParaEntity(livroAtualizacaoInput.getAutoresIds()));
	}


	public Page<LivroSemAutorOutput> listaLivrosComAutorParaListaLivrosSemAutor(Page<LivroEntity> listaLivrosComAutor) {
		 return listaLivrosComAutor.map(this::livroSemAutorParaOutput);
	} 
}
