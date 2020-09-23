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
import com.vsj.mercadolivre.forms.NovoUsuarioForm;

@RestController
@RequestMapping("/usuario")
public class NovoUsuarioController {

  @PersistenceContext
  private EntityManager manager;


  @PostMapping
  @Transactional
  public ResponseEntity<?> criaUsuario(@Valid @RequestBody NovoUsuarioForm form) {

    manager.persist(form.toModel());
    return ResponseEntity.ok().build();
  }
}
