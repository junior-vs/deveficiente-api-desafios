package org.ecorp.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pais {

  @Id
  @SequenceGenerator(name = "PAIS_PAISID_GENERATOR", sequenceName = "PAIS_PAISID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIS_PAISID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long paisID;

  @Column(nullable = false, unique = true)
  private String nomePais;

  @Deprecated
  public Pais() {
    // Auto-generated constructor stub
  }

  public Pais(Long paisID, String nomePais) {
    this.paisID = paisID;
    this.nomePais = nomePais;
  }



  public Pais(String nomePais) {
    this.nomePais = nomePais;
  }

  /**
   * @return the paisID
   */
  public Long getPaisID() {
    return paisID;
  }

  /**
   * @param paisID the paisID to set
   */
  public void setPaisID(Long paisID) {
    this.paisID = paisID;
  }

  /**
   * @return the nomePais
   */
  public String getNomePais() {
    return nomePais;
  }

  /**
   * @param nomePais the nomePais to set
   */
  public void setNomePais(String nomePais) {
    this.nomePais = nomePais;
  }



}
