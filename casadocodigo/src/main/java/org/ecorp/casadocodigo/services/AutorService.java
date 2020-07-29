package org.ecorp.casadocodigo.services;

import java.util.Optional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.AutorForm;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

  @Autowired
  private AutorRepository repository;

  public AutorForm create(@Valid AutorForm autorForm) {

    Autor saved = repository.save(autorForm.map());
    return AutorForm.from(saved);

  }

  public AutorForm buscaAutorById(Long id) {

    Optional<Autor> found = repository.findById(id);
    if (found.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    return AutorForm.from(found.get());
  }



}
