package org.ecorp.casadocodigo.services;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.CompraDTO;
import org.ecorp.casadocodigo.forms.CompraFormRequest;
import org.ecorp.casadocodigo.model.Compra;
import org.ecorp.casadocodigo.repositories.CompraRepository;
import org.ecorp.casadocodigo.repositories.EstadoRepository;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.ecorp.casadocodigo.repositories.PaisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

  @Autowired
  private PaisRepository reposotyPais;
  @Autowired
  private EstadoRepository reposotyEstado;
  @Autowired
  private LivroRespository livroRespository;
  @Autowired
  private CompraRepository repository;


  private static final Logger log = LoggerFactory.getLogger(CompraService.class);

  @Transactional
  public CompraDTO realizaCompra(@Valid CompraFormRequest compraForm) {

    Compra compra = compraForm.toModel(reposotyPais, reposotyEstado, livroRespository);
    repository.save(compra);
    return new CompraDTO(compra);
  }

}
