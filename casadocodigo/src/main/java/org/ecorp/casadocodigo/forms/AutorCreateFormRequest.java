package org.ecorp.casadocodigo.forms;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AutorCreateFormRequest {

  @NotEmpty
  @NotBlank
  private String autorNome;

  @NotEmpty
  @NotBlank
  @UniqueValue(domainClass = Autor.class, fieldName = "autor_email")
  private String autorEmail;

  @NotEmpty
  @NotBlank
  @Size(max = 400)
  private String descricao;

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


  public Autor map() {
    return new Autor(null, this.autorNome, this.autorEmail, this.descricao, LocalDateTime.now());
  }


  @JsonCreator
  public AutorCreateFormRequest(@NotEmpty @NotBlank String autorNome, @NotEmpty @NotBlank String autorEmail,
      @NotEmpty @NotBlank @Size(max = 400) String descricao) {
    this.autorNome = autorNome;
    this.autorEmail = autorEmail;
    this.descricao = descricao;
  }

}
