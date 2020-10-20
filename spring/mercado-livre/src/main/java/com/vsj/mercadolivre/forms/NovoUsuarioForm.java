package com.vsj.mercadolivre.forms;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.vsj.mercadolivre.model.Usuario;
import com.vsj.mercadolivre.validators.UniqueValue;

public class NovoUsuarioForm {

  @Email
  @NotBlank
  @UniqueValue(domainClass = Usuario.class, fieldName = "login")
  private String login;

  @NotBlank
  @Length(min = 6)
  private String senha;

  @JsonCreator
  public NovoUsuarioForm(
      @Email @NotBlank @UniqueValue(domainClass = Usuario.class, fieldName = "login") String login,
      @NotBlank @Size(min = 6) String senha) {
    this.login = Objects.requireNonNull(login);
    this.senha = Objects.requireNonNull(senha);
  }
   

  public String getLogin() {
    return login;
  }

  public String getSenha() {
    return senha;
  }

  public Usuario toModel() {
    return new Usuario(this);
  }

  @Override
  public String toString() {
    return String.format("NovoUsuarioForm [login=%s, senha=%s]", login, senha);
  }

}
