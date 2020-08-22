package org.ecorp.casadocodigo.model;

import static javax.persistence.GenerationType.SEQUENCE;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.validators.ExistsID;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

@Entity
public class Compra {

  @Id
  @SequenceGenerator(name = "COMPRA_COMPRAID_GENERATOR", sequenceName = "COMPRA_COMPRAID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "COMPRA_COMPRARID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long compraID;


  @NotBlank
  @Email
  private String emailComprador;

  @NotBlank
  private String nomeComprador;

  @NotBlank
  private String sobrenomeComprador;

  @NotBlank
  private String documento;

  @NotBlank
  public String rua;

  @NotBlank
  public String complemento;

  @NotBlank
  public String cidade;

  @NotNull
  @ExistsID(domainClass = Pais.class, fieldName = "paisID")
  public Long paisID;

  @ExistsID(domainClass = Estado.class, fieldName = "estadoID")
  public Long estadoID;

  @NotNull
  private String telefone;

  @NotBlank
  private String cep;

  @NotNull
  private BigDecimal total;

  /**
   * Criado para satisfazer o JPA
   */
  @Deprecated(since = "0.0.0")
  public Compra() {}

  public Compra(@NotBlank @Email String emailComprador, 
      @NotBlank String nomeComprador,
      @NotBlank String sobrenomeComprador, 
      @NotBlank String documento, 
      @NotBlank String rua,
      @NotBlank String complemento, 
      @NotBlank String cidade,
      @NotNull @ExistsID(domainClass = Pais.class, fieldName = "paisID") Long paisID,
      @ExistsID(domainClass = Estado.class, fieldName = "estadoID") Long estadoID,
      @NotNull String telefone,
      @NotBlank String cep, 
      @NotNull BigDecimal total) {
    
    this.emailComprador = Objects.requireNonNull(emailComprador);
    this.nomeComprador = Objects.requireNonNull(nomeComprador);
    this.sobrenomeComprador = Objects.requireNonNull(sobrenomeComprador);
    this.documento = Objects.requireNonNull(documento);
    this.rua = Objects.requireNonNull(rua);
    this.complemento = Objects.requireNonNull(complemento);
    this.cidade = Objects.requireNonNull(cidade);
    this.paisID = Objects.requireNonNull(paisID);
    this.estadoID = estadoID;
    this.telefone = Objects.requireNonNull(telefone);
    this.cep = Objects.requireNonNull(cep);
    this.total = Objects.requireNonNull(total);
  }


  public boolean documentoValido() {
    Assert.hasLength(documento,
        "voce não deveria validar o documento se ele não tiver sido preenchido");

    CPFValidator cpfValidator = new CPFValidator();
    cpfValidator.initialize(null);

    CNPJValidator cnpjValidator = new CNPJValidator();
    cnpjValidator.initialize(null);

    return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);

  }


  public String getEmailComprador() {
    return emailComprador;
  }


  public String getNomeComprador() {
    return nomeComprador;
  }


  public String getSobrenomeComprador() {
    return sobrenomeComprador;
  }


  public String getDocumento() {
    return documento;
  }


  public String getRua() {
    return rua;
  }


  public String getComplemento() {
    return complemento;
  }


  public String getCidade() {
    return cidade;
  }


  public Long getPaisID() {
    return paisID;
  }


  public Long getEstadoID() {
    return estadoID;
  }


  public String getTelefone() {
    return telefone;
  }


  public String getCep() {
    return cep;
  }


  @Override
  public String toString() {
    return String.format(
        "CompraFormRequest [emailComprador=%s, nomeComprador=%s, sobrenomeComprador=%s, documento=%s, rua=%s, complemento=%s, cidade=%s, paisID=%s, estadoID=%s, telefone=%s, cep=%s, total=%s",
        emailComprador, nomeComprador, sobrenomeComprador, documento, rua, complemento, cidade,
        paisID, estadoID, telefone, cep, total);
  }



}
