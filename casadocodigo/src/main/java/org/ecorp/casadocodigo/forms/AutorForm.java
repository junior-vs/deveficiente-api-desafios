package org.ecorp.casadocodigo.forms;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AutorForm {


  private Long autorID;

  @NotEmpty
  @NotBlank
  private String autorNome;

  @NotEmpty
  @NotBlank
  @UniqueValue(domainClass  = Autor.class, fieldName = "autor_email")
  private String autorEmail;

  @NotEmpty
  @NotBlank
  @Size(max = 400)
  private String descricao;

  @PastOrPresent
  private LocalDateTime tsAlteracao;

  private static AutorForm autorForm;

  public Long getAutorID() {
    return autorID;
  }

  public void setAutorID(final Long autorID) {
    this.autorID = autorID;
  }

  public String getAutorNome() {
    return autorNome;
  }

  public void setAutorNome(final String autorNome) {
    this.autorNome = autorNome;
  }

  public String getAutorEmail() {
    return autorEmail;
  }

  public void setAutorEmail(final String autorEmail) {
    this.autorEmail = autorEmail;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  public LocalDateTime getTsAlteracao() {
    return tsAlteracao;
  }

  public void setTsAlteracao(final LocalDateTime tsAlteracao) {
    this.tsAlteracao = tsAlteracao;
  }

  public Autor map() {
    return new Autor(this);
  }


  public static AutorForm from(final Autor entity) {
    autorForm = new AutorForm();
    autorForm.autorID = entity.getAutorID();
    autorForm.autorNome = entity.getAutorNome();
    autorForm.autorEmail = entity.getAutorEmail();
    autorForm.descricao = entity.getDescricao();
    autorForm.tsAlteracao = entity.getTsAlteracao();
    return autorForm;
  }

  public AutorForm() {
    this.tsAlteracao = LocalDateTime.now();
  }

  @JsonCreator
  public AutorForm(Long autorID, @NotEmpty @NotBlank String autorNome,
      @NotEmpty @NotBlank String autorEmail,
      @NotEmpty @NotBlank @Size(max = 400) String descricao) {
    this();
    this.autorID = autorID;
    this.autorNome = autorNome;
    this.autorEmail = autorEmail;
    this.descricao = descricao;
  }



}
