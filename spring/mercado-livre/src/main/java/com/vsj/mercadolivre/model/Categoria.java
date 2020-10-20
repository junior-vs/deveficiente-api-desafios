package com.vsj.mercadolivre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Categoria {

  @Id
  @Column(unique = true)
  private String nome;

  @OneToOne
  private Categoria categoriaMae;

  @Deprecated
  public Categoria() {
    // Auto-generated constructor stub
  }

  public Categoria(String nome, Categoria categoriaMae) {
    super();
    this.nome = nome;
    this.categoriaMae = categoriaMae;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Categoria getCategoriaMae() {
    return categoriaMae;
  }

  public void setCategoriaMae(Categoria categoriaMae) {
    this.categoriaMae = categoriaMae;
  }

  @Override
  public String toString() {
    return String.format("Categoria [nome=%s, categoriaMae=%s]", nome, categoriaMae);
  }



}
