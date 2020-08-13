package org.ecorp.casadocodigo.services;

import java.util.Optional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.LivroDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.LivroCreateFormRequest;
import org.ecorp.casadocodigo.model.Livro;
import org.ecorp.casadocodigo.repositories.AutorRepository;
import org.ecorp.casadocodigo.repositories.CategoriaRepository;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {


  private static final Logger logger = LoggerFactory.getLogger(LivroService.class);


  @Autowired
  private LivroRespository repository;

  @Autowired
  private AutorRepository autorRepository;

  @Autowired
  private CategoriaRepository categoriaRepository;

  public LivroDTO buscaAutorById(Long id) {
    Optional<Livro> found = repository.findById(id);
    if (found.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    return new LivroDTO(found.get());
  }


  public LivroDTO create(@Valid LivroCreateFormRequest livroRequest) {

    Livro livro = livroRequest.map();
    livro.setAutor(autorRepository.findById(livroRequest.getAutorID()).orElseThrow());
    livro.setCategoria(categoriaRepository.findById(livroRequest.getCategoriaID()).orElseThrow());
    logger.info(livro.toString());
    livro = repository.save(livro);


    return new LivroDTO(livro);
  }

}
