package com.vsj.mercadolivre.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vsj.mercadolivre.forms.CategoriaFormRequest;
import com.vsj.mercadolivre.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CadastroCategoriaController {

  @PersistenceContext
  private EntityManager manager;

  //2
  @PostMapping
  @Transactional
  public ResponseEntity<?> criaCategoria(@Valid @RequestBody CategoriaFormRequest form) {
    Categoria categoria = form.toModel(manager);
    manager.persist(categoria);
    return ResponseEntity.ok().build();
  }

}
