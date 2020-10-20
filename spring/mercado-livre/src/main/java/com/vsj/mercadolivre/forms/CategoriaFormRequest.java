package com.vsj.mercadolivre.forms;

import java.util.Objects;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vsj.mercadolivre.model.Categoria;
import com.vsj.mercadolivre.validators.Exist;
import com.vsj.mercadolivre.validators.UniqueValue;

public class CategoriaFormRequest {

  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
  private final String nome;

  @JsonProperty("categoria_mae")
  @Exist(domainClass = Categoria.class, fieldName = "nome")
  private String cagetoriaMae;


  @JsonCreator
  public CategoriaFormRequest(
      @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome") String nome) {
    super();
    this.nome = Objects.requireNonNull(nome);
  }

  @JsonCreator
  public CategoriaFormRequest(
      @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome") String nome,
      String cagetoriaMae) {
    this(nome);
    this.cagetoriaMae = cagetoriaMae;
  }

  public Categoria toModel(EntityManager manager) {
    Categoria categoriaMae = null;
    if (this.cagetoriaMae != null)
      categoriaMae = manager.find(Categoria.class, this.cagetoriaMae);

    return new Categoria(nome, categoriaMae);

  }

  public String getNome() {
    return nome;
  }

  public String getCagetoriaMae() {
    return cagetoriaMae;
  }

  @Override
  public String toString() {
    return String.format("CategoriaFormRequest [nome=%s, cagetoriaMae=%s]", nome, cagetoriaMae);
  }
}
