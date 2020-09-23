package com.vsj.mercadolivre.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.google.common.hash.Hashing;
import com.vsj.mercadolivre.forms.NovoUsuarioForm;

@Entity
public class Usuario {

    @Email
    @NotBlank
    @Id
    private String login;

    @NotBlank
    private String senhaCriptpgrafada;

    @Column(updatable = false, nullable = false)
    private LocalDateTime instant;

    public Usuario(NovoUsuarioForm novoUsuarioForm) {
        this.instant = LocalDateTime.now();
        this.login = novoUsuarioForm.getLogin();
        this.senhaCriptpgrafada = criptografa(novoUsuarioForm.getSenha());
    }

    @Deprecated
    public Usuario() {
    }

    private String criptografa(String senha) {
      return Hashing.sha256().hashUnencodedChars(senha).toString();
    }

}
