package br.com.aceleragep.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.aceleragep.biblioteca.entities.AutorEntity;
import br.com.aceleragep.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	//Lista Todos
	public Page<AutorEntity> listarTodos(Pageable paginacao) {
		return autorRepository.findAll(paginacao);
	}

	//Busca por Id
	public AutorEntity buscaPorId(Long autorId) {
		return autorRepository.findById(autorId)
				.orElseThrow(() -> new RuntimeException("Autor não encontrado"));
	}

	//Salva
	public AutorEntity cadastrar(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}

	//Atualizar
	public AutorEntity atualizar(AutorEntity autorEncontrado) {
		return autorRepository.save(autorEncontrado);
	}

}
