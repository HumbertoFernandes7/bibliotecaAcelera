package br.com.aceleragep.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.aceleragep.biblioteca.entities.LivroEntity;
import br.com.aceleragep.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;

	public Page<LivroEntity> listarTodos(Pageable paginacao) {
		return livroRepository.findAll(paginacao);
	}

	//Busca por Id
	public LivroEntity buscaPorId(Long autorId) {
		return livroRepository.findById(autorId)
				.orElseThrow(() -> new RuntimeException("Livro não encontrado !"));
	}

	//Cadastra
	public LivroEntity cadastrar(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}

	
	//Atualiza
	public LivroEntity atualizar(LivroEntity livroEncontrado) {
		return livroRepository.save(livroEncontrado);
		
	}

	public void deletar(LivroEntity livroEncontrado) {
		 livroRepository.delete(livroEncontrado);
	}

	public Page<LivroEntity> buscaLivroPeloIdAutor(Long autorId, Pageable paginacao) {
		return livroRepository.findAllByAutoresId(autorId, paginacao);
	}
}
