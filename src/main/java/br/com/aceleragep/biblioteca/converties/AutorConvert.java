package br.com.aceleragep.biblioteca.converties;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.aceleragep.biblioteca.dto.inputs.AutorInput;
import br.com.aceleragep.biblioteca.dto.outputs.AutorOutput;
import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.services.AutorService;

@Component
public class AutorConvert {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AutorService autorService;

	public Page<AutorOutput> ListaEntityParaListaOutput(Page<AutorEntity> autores) {
		return autores.map(this::entityParaOutput);
	}

	public AutorOutput entityParaOutput(AutorEntity autoresEntity) {
		return modelMapper.map(autoresEntity, AutorOutput.class);
	}

	public AutorEntity inputParaEntity(AutorInput autorInput) {
		return modelMapper.map(autorInput, AutorEntity.class);
	}

	public void copiaInputParaEntity(AutorEntity autorEncontrado, AutorInput autorAtualizacaoInput) {
		modelMapper.map(autorAtualizacaoInput, autorEncontrado);
	}

	public List<AutorEntity> longParaEntity(List<Long> listLong) {	
		return listLong.stream().map(autorService::buscaPorId).collect(Collectors.toList());
	}

}
